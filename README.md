# JavaFX MVC Template

Template proyek JavaFX dengan pola Model-View-Controller (MVC) yang siap digunakan.

## Konfigurasi

- **Java**: 25
- **JavaFX**: 25.0.1
- **Maven**: 3.9.x atau lebih baru
- **Build Tool**: Maven

## Struktur Proyek

```
JavaFX-Template/
├── src/
│   └── main/
│       ├── java/
│       │   ├── Controller/
│       │   │   └── AppController.java
│       │   ├── Model/
│       │   │   └── DataModel.java
│       │   ├── View/
│       │   │   ├── AlertHelper.java
│       │   │   └── InputValidator.java
│       │   └── Main.java
│       └── resources/
│           └── app_view.fxml
├── pom.xml
├── run-maven.bat
└── README.md
```

## Fitur Template

### Model
- JavaFX Property binding
- Sample model dengan 3 field

### View
- SceneBuilder-compatible FXML
- AlertHelper untuk dialog alerts
- InputValidator untuk validasi input

### Controller
- CRUD operations lengkap (Create, Read, Update, Delete)
- ObservableList untuk data management
- TableView dengan 3 kolom
- Validasi input

## Cara Menjalankan

### 1. Double-click Batch File
```
run-maven.bat
```

### 2. Command Line
```bash
mvn javafx:run
```

### 3. IntelliJ IDEA
- Import sebagai Maven project
- Run Main.java

## Cara Menggunakan Template

1. **Copy folder ini** untuk proyek baru
2. **Edit pom.xml**:
   - Ubah `groupId`, `artifactId`, `name`, dan `description`
3. **Edit Main.java**:
   - Ubah title aplikasi
   - Ubah author name
4. **Customize FXML** menggunakan SceneBuilder
5. **Modify Model** sesuai kebutuhan data
6. **Update Controller** untuk logika bisnis

## Build Commands

### Clean and Compile
```bash
mvn clean compile
```

### Run Application
```bash
mvn javafx:run
```

### Package as JAR
```bash
mvn clean package
```

## Requirements

- JDK 25 atau lebih baru
- Maven 3.9.x atau lebih baru
- JavaFX 25.0.1 (otomatis di-download oleh Maven)

## Catatan

- FXML file kompatibel dengan SceneBuilder
- Tanpa CSS inline styling
- Package structure sudah terorganisir
- Siap untuk dikembangkan lebih lanjut
