// package keywords;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.time.Duration;
// import java.util.Date;
// import java.util.List;
// import java.util.Properties;

// import org.testng.asserts.SoftAssert;

// public class connections {

//         public Properties prop;
//         public Properties envProp;
//         public SoftAssert softAssert;

//  String path = System.getProperty("user.dir") + "//src//test//resources//env.properties";
//         prop = new Properties();
//         envProp = new Properties();
//         try {
//             FileInputStream fs = new FileInputStream(path);
//             prop.load(fs);
//             String env = prop.getProperty("env") + ".properties";
//             path = System.getProperty("user.dir") + "//src//test//resources//" + env;
//             fs = new FileInputStream(path);
//             envProp.load(fs);
//         } catch (Exception e) {

//             e.printStackTrace();
//         }
//         softAssert = new SoftAssert();
//         }
