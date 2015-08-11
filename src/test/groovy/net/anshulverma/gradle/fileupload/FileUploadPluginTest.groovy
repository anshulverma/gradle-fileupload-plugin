package net.anshulverma.gradle.fileupload

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import static org.junit.Assert.assertTrue

/**
 * @author Adobe Systems Inc.
 */
class FileUploadPluginTest {

  @Test
  public void canAddTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    def task = project.task('fileupload', type: FileUploadTask)
    assertTrue(task instanceof FileUploadTask)
  }

  @Test
  public void fileuploadPluginAddsFileUploadTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'net.anshulverma.gradle.fileupload'

    assertTrue(project.tasks.fileupload instanceof FileUploadTask)
  }
}
