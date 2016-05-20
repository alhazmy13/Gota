<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/4659608/12700078/f9528158-c7e4-11e5-9a30-8ec0999be0ad.png" width="400">
</p>
#Gota Libary
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/crates/l/rustc-serialize.svg)
![](https://img.shields.io/badge/version-2.0.0-blue.svg)

With Android 6.0 Marshmallow, Google introduced a new permission model that allows users to better understand why an application may be requesting specific permissions. Rather than the user blindly accepting all permissions at install time, the user is now prompted to accept permissions as they become necessary during application use. As you probably already know, such a change requires efforts on the part of the application developer, this libary will help you to requset any number of permissions with a simple way.

You can report any issue on issues page. **Note: If you speak Arabic, you can submit issues with Arabic language and I will check them. :)**

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/4659608/11697977/8366a464-9ecd-11e5-92a2-55114ea91965.gif">
</p>


------ 
## Install
**Maven**

```xml
<dependency>
<groupId>net.alhazmy13.Gota</groupId>
<artifactId>libary</artifactId>
<version>2.0.0</version>
</dependency>
```

**Gradle**

```gradle

dependencies {
	compile 'net.alhazmy13.Gota:libary:2.0.0'
}
```

------ 
# Usage


After adding the library, you just need to create an instance from Gota libary and passing an array of permissions.

```java
new Gota.Builder(this)
                .withPermissions(Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE)
                .setListener(this)
                .check();
```
### `OnRequestPermissionsBack`
In order to receive the response, you will need to implement the `OnRequestPermissionsBack`  interfaces.
```java
   @Override
       public void onRequestBack(GotaResponse gotaResponse) {
           if(gotaResponse.isGranted(Manifest.permission.CAMERA)) {
              Log.d(TAG, "GRATED")
           }
       
       }
```

### `GotaResponse` methods
 
 * `deniedPermissions()` 
     * Return a list of denied permissions.
 * `grantedPermissions()`
      * Return a list of grated permissions.
 * `isGranted(String)`
    * To check if the permission was granted or not.   
 *  `isDenied(String)`
    * To check if the permission was denied or not.   
 * `isAllGranted()`
    * return true if the all permission was grated
 * `isAllDenied()`
    * return true if the all permission was denied
 * `hasDeniedPermission()`
    * return true if there's any denied permission

## Wiki

* [Arabic](http://alhazmy13.net/runtimepermission_and_gota/)
* [English](https://github.com/alhazmy13/Gota/blob/master/README.md)

## License
------ 
    Copyright 2015 alhazmy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    

