set - e
# Ejecutar servidor
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_5lsyh04kpz6wivacfsf4bvltd.argfile edu.unam.server.App 8000 &
# Ejecutar nodos
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node1 5 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node2 0.2 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node3 0.3 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node4 0.4 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node5 0.5 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node6 2.5 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node7 0.5 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node8 0.8 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node9 0.5 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node10 0.9 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node11 0.2 localhost 8000 &
/usr/java/openjdk-15/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_4hpyx0pjswpq4dnrfetlv801m.argfile edu.unam.app.App node12 0.1 localhost 8000 &