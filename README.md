# TestNDKUpdataUI
通过 NDK 实现更改界面 EditText 显示的文本内容

Error:(12, 0) Error: NDK integration is deprecated in the current plugin.  
Consider trying the new experimental plugin.  
For details, see http://tools.android.com/tech-docs/new-build-system/gradle-experimental.  
Set "android.useDeprecatedNdk=true" in gradle.properties to continue using the current NDK integration.

Here is how to solve this issue :

Add gradle.properties file to root folder of your project.
Add android.useDeprecatedNdk=true to gradle.properties file.

Here is gradle.properties :

android.useDeprecatedNdk=true

And rebuild your project.
