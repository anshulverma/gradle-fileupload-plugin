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

import org.gradle.api.Project

/**
 * @author Anshul Verma (anshul.verma86@gmail.com)
 */
class FileUploadExtension {

  Project project

  String url
  String file
  String name
  Map<String, String> params = new HashMap<>()
  Map<String, String> headers = new HashMap<>()
  FileUploadAuthExtension authSettings

  FileUploadExtension(Project project) {
    this.project = project
  }

  void auth(Closure closure) {
    authSettings = new FileUploadAuthExtension()
    closure.delegate = authSettings
    closure()
    authSettings
  }

  boolean isAuthEnabled() {
    authSettings != null
  }
}
