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
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author Anshul Verma (anshul.verma86@gmail.com)
 */
class FileUploadPluginTest {

  @Test
  void canAddTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    def task = project.task('fileupload', type: FileUploadTask)
    assert (task instanceof FileUploadTask)
  }

  @Test
  void fileuploadPluginAddsFileUploadTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'net.anshulverma.gradle.fileupload'

    assert (project.tasks.fileupload instanceof FileUploadTask)
  }
}
