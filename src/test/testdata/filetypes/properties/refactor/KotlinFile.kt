import com.badlogic.gdx.utils.I18NBundle
import com.gmail.blueboxware.libgdxplugin.annotations.GDXAssets

internal class JavaClass {

  @GDXAssets(propertiesFiles = arrayOf("src/messages.properties" ))
  var i18NBundle: I18NBundle = I18NBundle()
  @GDXAssets(propertiesFiles = ["src/doesnotexist.properties" ])
  var i18NBundle2: I18NBundle = I18NBundle()
  @GDXAssets(propertiesFiles = ["src/extra.properties", "src/messages.properties" ])
  var i18NBundle3: I18NBundle = I18NBundle()
  @GDXAssets(propertiesFiles = arrayOf"src/extra.properties", "src/test.properties" ))
  var i18NBundle4: I18NBundle = I18NBundle()

  var s = i18NBundle.get("newName1")

  fun m() {
    I18NBundle().get("newName1")
    i18NBundle.format("newName1", "", Any())
    i18NBundle.format("newName1", "newName1", "")
    i18NBundle2.get("newName1")
    i18NBundle3.format("newName1")
    i18NBundle4.format("oldName")
  }
}