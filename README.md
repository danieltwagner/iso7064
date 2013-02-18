iso7064
=======

A simple Java library that calculates ISO 7064 check characters.

The algorithms currently included are all pure systems:
* ISO/IEC 7064, MOD 11-2 for numeric strings with one check digit or the supplementary check character "X"
* ISO/IEC 7064, MOD 37-2 for alphanumeric strings with one check digit or letter or the supplementary check character "*"
* ISO/IEC 7064, MOD 97-10 for numeric strings with two check digits
* ISO/IEC 7064, MOD 661-26 for alphabetic strings with two check letters
* ISO/IEC 7064, MOD 1271-36 for alphanumeric strings with two check digits or letters

This is a partial implementation of the ISO standard. Hybrid systems (which always produce a single check character within the character set of the string that is being protected) are not implemented at this time. The missing systems are:
* ISO/IEC 7064, MOD 11,10 for numeric strings with one check digit
* ISO/IEC 7064, MOD 27,26 for alphabetic strings with one check letter
* ISO/IEC 7064, MOD 37,36 for alphanumeric strings with one check digit or letter

```java
Mod11_2 numericCheck = new Mod11_2();

String protected = numericCheck.compute("123456");
boolean result = numericCheck.verify("123456X");
```