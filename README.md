####1. Define proto file 
(e.g. com/example/proto/HelloService.proto)

####2. Generate sources:
#####2.1 Using protocol buffer compiler:
`protoc --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN -I=$SRC_DIR 
  --java_out=$DST_DIR --grpc-java_out=$DST_DIR $SRC_DIR/HelloService.proto`
#####2.2 Using Maven plugin:
Protocol buffer definitions are looked up under src/main/proto/ directory by default. 
Any subdirectories under src/main/proto/ are treated as package structure for protobuf definition imports.

```xml
<build>
  <extensions>
    <extension>
      <groupId>kr.motd.maven</groupId>
      <artifactId>os-maven-plugin</artifactId>
      <version>1.6.1</version>
    </extension>
  </extensions>
  <plugins>
    <plugin>
      <groupId>org.xolstice.maven.plugins</groupId>
      <artifactId>protobuf-maven-plugin</artifactId>
      <version>0.6.1</version>
      <configuration>
        <protocArtifact>
          com.google.protobuf:protoc:3.3.0:exe:${os.detected.classifier}
        </protocArtifact>
        <pluginId>grpc-java</pluginId>
        <pluginArtifact>
          io.grpc:protoc-gen-grpc-java:1.4.0:exe:${os.detected.classifier}
        </pluginArtifact>
      </configuration>
      <executions>
        <execution>
          <goals>
            <goal>compile</goal>
            <goal>compile-custom</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```
The os-maven-plugin extension/plugin generates various useful platform-dependent project properties like ${os.detected.classifier}

`mvn clean install`

####3. Implement service
The default implementation of the abstract class HelloServiceImplBase is to throw runtime exception io.grpc.StatusRuntimeException saying that the method is unimplemented.
We need to extend HelloServiceImplBase and override base methods
####4. Start service
The easiest way is to start from com/example/service/App.java class
####5. Run test
com.example.ServiceTest
