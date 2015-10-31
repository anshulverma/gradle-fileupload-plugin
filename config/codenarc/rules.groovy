/*
* Copyright 2013 the original author or authors
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
ruleset {
  description 'Rules For Gradle Estilo Plugin Project'
  ruleset('rulesets/basic.xml')
  ruleset('rulesets/braces.xml')
  ruleset('rulesets/concurrency.xml')
  ruleset('rulesets/convention.xml')
  ruleset('rulesets/design.xml') {
    AbstractClassWithoutAbstractMethod(enabled: false)
  }
  ruleset('rulesets/dry.xml') {
    DuplicateStringLiteral(enabled: false) // too much hassle
  }
  ruleset('rulesets/exceptions.xml')
  ruleset('rulesets/formatting.xml') {
    ClassJavadoc(enabled: false)
    SpaceAroundMapEntryColon(characterBeforeColonRegex: /(\s|\S)/,
                             characterAfterColonRegex: /\s/)
  }
  // generic rules need to be configured to be active and useful
  //ruleset('rulesets/generic.xml')
  IllegalRegex {
    name = 'TODO'
    priority = 2
    regex = /TODO/
    description = 'TODOs should not be commited'
  }

  RequiredRegex {
    name = 'ApacheLicenseRequired'
    regex = /(?m)^\/\*\*$\n^ \* Copyright 2015 Anshul Verma. All Rights Reserved.$\n^ \*$\n^ \* Licensed under the Apache License, Version 2.0 \(the "License"\);$/
    violationMessage = 'The Apache License 2.0 comment is missing from the source file'
    description = 'Checks that all source files contain the Apache License 2.0 comment'
  }

  RequiredRegex {
    name = 'AuthorRequired'
    regex = /@author Anshul Verma \(anshul.verma86@gmail.com\)/
    violationMessage = 'The @author comment is missing from the source file'
    description = 'Checks that all source files contain the @author comment'
  }

  ruleset('rulesets/groovyism.xml') {
    GetterMethodCouldBeProperty(enabled: false)
    GStringExpressionWithinString(enabled: false) // regex contains this as parameter
  }
  ruleset('rulesets/imports.xml') {
    NoWildcardImports(enabled: false)
  }
  ruleset('rulesets/junit.xml')
  ruleset('rulesets/logging.xml')
  ruleset('rulesets/naming.xml') {
    FactoryMethodName(enabled: false)
  }
  ruleset('rulesets/security.xml') {
    JavaIoPackageAccess(enabled: false) // gradle uses Java.io.File
  }
  ruleset('rulesets/serialization.xml')

  ruleset('rulesets/unnecessary.xml') {
    UnnecessaryDefInMethodDeclaration(enabled: false)
    UnnecessaryGetter(enabled: false)
    UnnecessaryReturnKeyword(enabled: false)
    UnnecessaryCast(enabled: false) // buggy
  }
  ruleset('rulesets/unused.xml')
}
