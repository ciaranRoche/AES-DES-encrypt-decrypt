# AES and DES

### Usage

Clone project, navigate to src folder

```
\\ compiles all java files to executable class files
$ javac *.java
\\ Generate Keys for AES and DES
$ java AESKeyGen && java DESKeyGen
```
To generate cypher text run and Encrypt class followed by string you want to encrypt.
```
$ java AESCBCEncrypt.class 'we attack at dawn' 
```
Example output:
``` 
Plaintext: We attack at Dawn
Ciphertext: 0b 67 f7 44 2f ac 0e 0e 0c 6f 8c ff fc aa 0f 44 b6 cf ce db 0d 9a 95 ea 9c 41 7e de 3e 0a ee 95
```
The cipher text is saved to file 'scrambled'

To decrypt cipher:
``` 
$ java java AESCBCDecrypt.class
```