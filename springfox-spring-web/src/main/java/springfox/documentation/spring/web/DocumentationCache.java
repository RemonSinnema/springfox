/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.documentation.spring.web;

import springfox.documentation.service.Documentation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DocumentationCache {
  private Map<String, Documentation> documentationLookup = new LinkedHashMap<>();
  private Map<String, Object> serializedDocumentationLookup = new LinkedHashMap<>();

  public void addDocumentation(Documentation documentation) {
    documentationLookup.put(documentation.getGroupName(), documentation);
  }

  public void addSerializedDocumentation(String groupName, Object serialized) {
      serializedDocumentationLookup.put(groupName, serialized);
  }

  public Documentation documentationByGroup(String groupName) {
    return documentationLookup.get(groupName);
  }

  public <T> T getSerializedDocumentationByGroup(String groupName, Class<T> clazz) {
    Object serialized = serializedDocumentationLookup.get(groupName);
    if (serialized != null && clazz.isAssignableFrom(serialized.getClass())) {
        return (T) serialized;
    }
    return null;
  }

  public Map<String, Documentation> all() {
    return Collections.unmodifiableMap(documentationLookup);
  }

  public Map<String, Object> allSerialized() {
        return Collections.unmodifiableMap(serializedDocumentationLookup);
    }

  public void clear() {
    documentationLookup.clear();
    serializedDocumentationLookup.clear();
  }
}
