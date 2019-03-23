package com.gmail.blueboxware.libgdxplugin.filetypes.json

import com.intellij.json.JsonFileType
import com.intellij.openapi.fileTypes.LanguageFileType


/*
 * Copyright 2019 Blue Box Ware
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
class LibGDXJsonFileType private constructor(): LanguageFileType(LibGDXJsonLanuage.INSTANCE) {

  companion object {
    val INSTANCE = LibGDXJsonFileType()
  }

  override fun getIcon() = JsonFileType.INSTANCE.icon

  override fun getName() = "LibGDX JSON"

  override fun getDefaultExtension() = "lson"

  override fun getDescription() = "LibGDX JSON file"

}