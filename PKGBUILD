pkgname=file-organizer
pkgver=1.0
pkgrel=1
pkgdesc="A simple Java tool to organize files by type"
arch=('any')
url="https://github.com/NullableV1/File-Organizer"
license=('MIT')
depends=('java-runtime')
makedepends=('jdk-openjdk')
source=("FileOrganizer.java")
sha512sums=('SKIP')

build() {
  cd "$srcdir"
  javac FileOrganizer.java
  jar cfe FileOrganizer.jar FileOrganizer FileOrganizer.class
}

package() {
  install -Dm755 "$srcdir/FileOrganizer.jar" "$pkgdir/usr/share/java/$pkgname/FileOrganizer.jar"
  install -Dm755 /dev/stdin "$pkgdir/usr/bin/file-organizer" <<EOF
#!/bin/bash
exec java -jar /usr/share/java/$pkgname/FileOrganizer.jar "\$@"
EOF
}
 
