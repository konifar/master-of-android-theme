package com.konifar.moat

enum class ThemeConfig(
    var darkMode: Boolean,
    var showCaseThemeResId: Int
) {
    CAT_ONE(false, 0),
    CAT_TWO(false, 0),
    CAT_COLORFUL(false, R.style.MoatVividCaseStudyTheme);
}