package com.konifar.moat

enum class ThemeConfig(
    val index: Int,
    val appCompatThemeResId: Int,
    val materialThemeResId: Int,
    var darkMode: Boolean
) {

    CAT_ONE(0, R.style.MoatAppCompatTheme_CatOne, R.style.MoatMaterialTheme_CatOne, false),
    CAT_TWO(1, R.style.MoatAppCompatTheme_CatTwo, R.style.MoatMaterialTheme_CatTwo, false),
    CAT_COLORFUL(2, R.style.MoatAppCompatTheme_CatColorful, R.style.MoatMaterialTheme_CatColorful, false);

    companion object {
        fun from(index: Int): ThemeConfig {
            return when (index) {
                0 -> CAT_ONE
                1 -> CAT_TWO
                2 -> CAT_COLORFUL
                else -> throw IllegalArgumentException("$index is not supported.")
            }
        }
    }
}