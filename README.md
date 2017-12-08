# Driver License Parser Library for Android

This project demonstrates how to use **Driver License Parser library for Android** from [IDScan.net](https://idscan.net/).

## Installation

1. Download the [latest version](https://idscan.net/support/dlparser-android-sdk-documentation/) of **Driver License Parser Library for Android**. The archive contains next components:
    - **Native libraries for different platforms** (./arm64-v8a/libidscan_parser.so,  ./armeabi/libidscan_parser.so,  ./armeabi-v7a/libidscan_parser.so,  ./mips/libidscan_parser.so,  ./mips64/libidscan_parser.so,  ./x86/libidscan_parser.so,  ./x86_64/libidscan_parser.so)

    - **Java wrapper** (./dlparserlib.jar).

2. Put native libraries in '**{MODULE}/src/main/jniLibs**' folder of your project. The project structure looks like this:
```
{MODULE}
  ├ src
    ├ main
      ├ jniLibs
        ├ arm64-v8a
        |   └ libidscan_parser.so
        ├ armeabi
        |   └ libidscan_parser.so
        ├ armeabi-v7a
        |   └ libidscan_parser.so
        ├ mips
        |   └ libidscan_parser.so
        ├ mips64
        |   └ libidscan_parser.so
        ├ x86
        |   └ libidscan_parser.so
        ├ x86_64
            └ libidscan_parser.so
```

3. Put **dlparserlib.jar** in '**{MODULE}/libs**' folder of your project. The project structure looks like this:
```
{MODULE}
  ├ libs
  |   └ dlparserlib.jar
  ├ src
    ├ main
      ├ jniLibs
        ├ arm64-v8a
        |   └ libidscan_parser.so
        ├ armeabi
        |   └ libidscan_parser.so
        ├ armeabi-v7a
        |   └ libidscan_parser.so
        ├ mips
        |   └ libidscan_parser.so
        ├ mips64
        |   └ libidscan_parser.so
        ├ x86
        |   └ libidscan_parser.so
        ├ x86_64
            └ libidscan_parser.so
```

4. Update the dependencies section in **builder.gradle** and synchronize the project.
```
dependencies {
    ...
    compile files('libs/dlparserlib.jar')
    ...
}
```
Or right-click on **dlparserlib.jar** file and select **Add Library**.

## Usage

1. Create ```DLParser``` object.  
```
DLParser parser = new DLParser();
```

2. Setup **License Key**. For setup **License Key** you need to call ```setup(Context, String)```. It accepts two parameters: application context and license key encoded as Base64 string.  
```
try {
    parser.setup(getApplicationContext(), "** LICENSE_KEY **");
} catch(DLParserException e) {
    // TODO: handle the error.
}
```

3. Parse the data. For parsing data you need to call ```parse(byte[])``` method.  
```
try {
    DLResult res = parser.parse(data);
} catch(DLParserException | UnsupportedEncodingException e) {
    // TODO: handle the error.
}
```

You will find a complete example of using the library in ```MainActivity.java```.
