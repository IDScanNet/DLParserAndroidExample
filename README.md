# Driver License Parser Library for Android

This project demonstrates how to use **Driver License Parser library for Android** from [IDScan.net](https://idscan.net/).

## Setup

1. Add **idscan-public** maven repository to the project **build.gradle** file.
```
allprojects {
    repositories {
        ...
        maven {
            url 'https://www.myget.org/F/idscan-public/maven/'
        }
        ...
    }
}
```

2. Add the following to the module **build.gradle** file:
```
dependencies {
    ...
    implementation 'net.idscan.components.android:dlparser-standard:1.28.4'
    ...
}
```

**Note** if you have already installed version before 1.28.4 you have to remove it from the project.

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
