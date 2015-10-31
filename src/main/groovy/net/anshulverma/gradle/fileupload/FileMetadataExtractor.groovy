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

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.AutoDetectParser
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.Parser
import org.apache.tika.sax.BodyContentHandler

/**
 * @author Anshul Verma (anshul.verma86@gmail.com)
 */
class FileMetadataExtractor {

  static FileMetadata process(String file) {
    def metadata = new Metadata()
    metadata.set(Metadata.RESOURCE_NAME_KEY, file)
    ParseContext parseContext = new ParseContext()
    Parser parser = new AutoDetectParser()
    parser.parse(new FileInputStream(file), new BodyContentHandler(), metadata, parseContext)
    return new FileMetadata(metadata)
  }
}
