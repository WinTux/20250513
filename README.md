Descargamos Apache Kafka desde https://kafka.apache.org/downloads

Para esto ejemplo descargamos la versión 3.7.2 (Scala 2.13)
Extraemos el contenido del archivo comprimido.
Por comodidad, y para evitar errores, movemos el folder extraído a la raíz de la partición

Para ejecutar Apache Kafka desde Windows:
Abrimos CMD como administrador, nos dirigimos alo folder de Kafka

C:\>cd kafka_2.13-3.7.2

C:\kafka_2.13-3.7.2>bin\windows\zookeeper-server-start.bat config\zookeeper.properties

Y desde otra ventana CMD como administrador
C:\kafka_2.13-3.7.2>bin\windows\kafka-server-start.bat config\server.properties
