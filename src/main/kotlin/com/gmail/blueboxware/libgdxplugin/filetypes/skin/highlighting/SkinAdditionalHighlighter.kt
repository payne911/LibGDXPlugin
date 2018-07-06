package com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting

import com.gmail.blueboxware.libgdxplugin.utils.PROPERTY_NAME_PARENT
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_CLASS_NAME
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_KEYWORD
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_NUMBER
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_PARENT_PROPERTY
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_PROPERTY_NAME
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.highlighting.SkinSyntaxHighlighterFactory.Companion.SKIN_RESOURCE_NAME
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.*
import com.gmail.blueboxware.libgdxplugin.utils.isLibGDX199
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

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
class SkinAdditionalHighlighter : Annotator {

  override fun annotate(element: PsiElement, holder: AnnotationHolder) {

    if (element is SkinPropertyName) {
      if (element.value == PROPERTY_NAME_PARENT && element.project.isLibGDX199()) {
        holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_PARENT_PROPERTY }
      } else {
        holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_PROPERTY_NAME }
      }
    } else if (element is SkinResourceName) {
      holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_RESOURCE_NAME }
    } else if (element is SkinStringLiteral) {
      if (element.parent is SkinClassName) {
        holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_CLASS_NAME }
      } else if (element.parent is SkinPropertyValue) {
        if (element.isBoolean || element.text == "null") {
          holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_KEYWORD }
        } else if (element.text.toDoubleOrNull() != null) {
          holder.createInfoAnnotation(element, null).apply { textAttributes = SKIN_NUMBER }
        }
      }
    }

  }

}