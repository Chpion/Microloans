1) командa для запуска jar-файла без явного указания профиля настроек
java -Xms2048m -Xmx4096m -jar "C:/Users/VAgafonov/Java/microloansStub/microloansStub-0.0.1-SNAPSHOT.jar"
2) командa для запуска jar-файла с профилем test1
java -Dspring.profiles.active=test2 -Xms2048m -Xmx4096m -jar "C:/Users/VAgafonov/Java/microloansStub/microloansStub-0.0.1-SNAPSHOT.jar"
3) командa для запуска jar-файла с профилем test2
java -Dspring.profiles.active=test2 -Xms2048m -Xmx4096m -jar "C:/Users/VAgafonov/Java/microloansStub/microloansStub-0.0.1-SNAPSHOT.jar"
