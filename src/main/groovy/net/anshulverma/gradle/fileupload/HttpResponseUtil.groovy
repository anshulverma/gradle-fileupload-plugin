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
import org.apache.http.entity.ContentType
import org.apache.http.util.EntityUtils

/**
 * @author Anshul Verma (anshul.verma86@gmail.com)
 */
@Slf4j
class HttpResponseUtil {

  static void logResponse(response) {
    log.debug("response body: \n${getBody(response)}")
  }

  private static String getBody(response) {
    return new String(EntityUtils.toByteArray(response.entity),
                      ContentType.getOrDefault(response.entity).charset)
  }
}
