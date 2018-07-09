/**
 * Copyright 2015 Anshul Verma. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.anshulverma.gradle.fileupload

import groovy.util.logging.Slf4j
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.entity.mime.content.StringBody
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * @author Anshul Verma (anshul.verma86@gmail.com)
 */
@Slf4j
class FileUploadTask extends DefaultTask {

  @TaskAction
  def doUpload() {
    def settings = (FileUploadExtension) getProject().getExtensions().findByName('fileupload')
    def metadata = FileMetadataExtractor.process(settings.file)
    def http = new HTTPBuilder(settings.url)

    if (settings.authEnabled) {
      http.auth.basic(settings.authSettings.username, settings.authSettings.password)
    }

    http.request(Method.POST) { request ->
      headers.'Accept' = 'application/json'

      settings.headers.each { name, value ->
        headers.name = value
      }

      def entityBuilder = MultipartEntityBuilder.create()
                                                .addBinaryBody(settings.name,
                                                               new File(settings.file),
                                                               metadata.contentType,
                                                               settings.file)
      settings.params.each { name, value ->
        entityBuilder.addPart(name, new StringBody(value))
      }

      request.entity = entityBuilder.build()

      response.success = {
        logger.info('uploaded file: {}', settings.file)
        HttpResponseUtil.logResponse(it)
      }
      response.failure = {
        logger.error('unable to upload file: {}', settings.file)
        HttpResponseUtil.logResponse(it)
      }
    }
  }
}
