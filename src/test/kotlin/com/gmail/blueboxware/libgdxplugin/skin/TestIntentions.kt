package com.gmail.blueboxware.libgdxplugin.skin

import com.gmail.blueboxware.libgdxplugin.LibGDXCodeInsightFixtureTestCase
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.SkinObject


/*
 * Copyright 2018 Blue Box Ware
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
class TestIntentions: LibGDXCodeInsightFixtureTestCase() {

  fun testColorConvertingIntentions() {

    myFixture.configureByFile("colorConvertingIntentions.skin")
    doAllIntentions<SkinObject>("Convert")
    myFixture.checkResultByFile("colorConvertingIntentions.after")
    doAllIntentions<SkinObject>("Convert")
    myFixture.checkResultByFile("colorConvertingIntentions.after2")

  }

  override fun getBasePath() = "/filetypes/skin/intentions/"

  override fun setUp() {
    super.setUp()

    addLibGDX()
    addDummyLibGDX199()
  }

}