package com.gmail.blueboxware.libgdxplugin.utils

import com.gmail.blueboxware.libgdxplugin.components.LibGDXProjectNonSkinFiles
import com.gmail.blueboxware.libgdxplugin.components.LibGDXProjectSkinFiles
import com.intellij.openapi.file.exclude.EnforcedPlainTextFileTypeManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotifications
import com.intellij.util.indexing.FileBasedIndex

/*
 * Copyright 2016 Blue Box Ware
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

fun markFileAsSkin(project: Project, file: VirtualFile, isSkin: Boolean) {

  if (project.isDisposed) return

  val skinFiles = project.getComponent(LibGDXProjectSkinFiles::class.java) ?: return
  val nonSkinFiles = project.getComponent(LibGDXProjectNonSkinFiles::class.java) ?: return

  if (isSkin) {

    nonSkinFiles.remove(file)
    skinFiles.add(file)
    EnforcedPlainTextFileTypeManager.getInstance().markAsPlainText(project, file)

  } else {

    skinFiles.remove(file)
    nonSkinFiles.add(file)
    EnforcedPlainTextFileTypeManager.getInstance().resetOriginalFileType(project, file)

  }

  FileBasedIndex.getInstance().requestReindex(file)
  EditorNotifications.getInstance(project).updateNotifications(file)

}


