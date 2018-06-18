import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.gmail.blueboxware.libgdxplugin.annotations.GDXAssets

@GDXAssets(atlasFiles = arrayOf(""), skinFiles = ["src\\findUsages/findUsagesWithTags3.skin"])
val s: Skin = Skin()

object O {
  @GDXAssets(atlasFiles = arrayOf(""), skinFiles = arrayOf("src\\findUsages\\findUsagesWithTags1.skin", "src/findUsages/findUsagesWithTags3.skin"))
  val skin: Skin = Skin()
}

fun f() {
  val c = s.get("toggle",  TextButton.TextButtonStyle::class.java)
  val d = O.skin.has("toggle",  TextButton.TextButtonStyle::class.java)
}