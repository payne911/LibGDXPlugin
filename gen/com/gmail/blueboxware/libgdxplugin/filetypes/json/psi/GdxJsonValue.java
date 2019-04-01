// This is a generated file. Not intended for manual editing.
package com.gmail.blueboxware.libgdxplugin.filetypes.json.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GdxJsonValue extends GdxJsonElement {

  @Nullable
  GdxJsonArray getArray();

  @Nullable
  GdxJsonJobject getJobject();

  @Nullable
  GdxJsonString getString();

  @Nullable
  GdxJsonElement getValue();

}
