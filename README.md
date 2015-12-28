
#Gota Libary

With Android 6.0 Marshmallow, Google introduced a new permission model that allows users to better understand why an application may be requesting specific permissions. Rather than the user blindly accepting all permissions at install time, the user is now prompted to accept permissions as they become necessary during application use. As you probably already know, such a change requires efforts on the part of the application developer, this libary will help you to requset any number of permissions with a simple way.

You can report any issue on issues page. **Note: If you speak Arabic, you can submit issues with Arabic language and I will check them. :)**

![Preview](https://cloud.githubusercontent.com/assets/4659608/11697977/8366a464-9ecd-11e5-92a2-55114ea91965.gif)


------ 
## Install
**Maven**

```xml
<dependency>
<groupId>net.alhazmy13.Gota</groupId>
<artifactId>libary</artifactId>
<version>1.0.0-beta</version>
</dependency>
```

**Gradle**

```gradle

dependencies {
	compile 'net.alhazmy13.Gota:libary:1.0.0-beta'
}
```

------ 
# Usage


After adding the library, you just need to create an instance from Gota libary and passing an array of permissions.

```java
new Gota(this).checkPermission(new String[]{Manifest.permission.CAMERA}, new Gota.OnRequestPermissionsBack() {
            @Override
            public void onRequestBack(GoaResponse goaResponse) {

            }
        });
```
### `OnRequestPermissionsBack`
In order to receive the response, you will need to implement the `OnRequestPermissionsBack`  interfaces.
```java
    @Override
    public void onRequestBack(GoaResponse goaResponse) {

    }
```

### `GotaResponse` methodes
 
 * `deniedPermissions()` 
     * Return a list of denied permissions.
 * `grantedPermissions()`
      * Return a list of denied permissions.
 * `isGranted(String)`
    * To check if the permission was granted or not.   
 *  `isDenied(String)`
    * To check if the permission was denied or not.   
 * `isAllGranted()`
 * `isAllDenied()`
 * `hasDeniedPermission()`

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
    

