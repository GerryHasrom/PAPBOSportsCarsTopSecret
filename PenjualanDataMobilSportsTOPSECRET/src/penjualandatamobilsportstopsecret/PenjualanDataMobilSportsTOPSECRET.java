/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package penjualandatamobilsportstopsecret;

/**
 *
 * @author Asus
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Mobil {
    private int idMobil;
    private int customerId;
    private String namaMobil;
    private String brandMobil;
    private String jenisMobil;
    private double hargaMobil;
    private String warnaMobil;
    private int tahunProduksi;
    private String negaraProduksi;
    private String additionalTechnology; // Teknologi tambahan untuk Supercar
    private String  maxSpeed; // Maksimum kecepatan untuk Open-wheel racing car
    private String engineType; // Jenis mesin untuk Sports Prototype

    public Mobil(String namaMobil, String brandMobil, String jenisMobil, double hargaMobil,
                 String warnaMobil, int tahunProduksi, String negaraProduksi) {
        this.namaMobil = namaMobil;
        this.brandMobil = brandMobil;
        this.jenisMobil = jenisMobil;
        this.hargaMobil = hargaMobil;
        this.warnaMobil = warnaMobil;
        this.tahunProduksi = tahunProduksi;
        this.negaraProduksi = negaraProduksi;
    }

    // Getter dan Setter
    public int getIdMobil() { return idMobil; }
    public void setIdMobil(int idMobil) { this.idMobil = idMobil; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getNamaMobil() { return namaMobil; }
    public void setNamaMobil(String namaMobil) { this.namaMobil = namaMobil; }
    public String getBrandMobil() { return brandMobil; }
    public void setBrandMobil(String brandMobil) { this.brandMobil = brandMobil; }
    public String getJenisMobil() { return jenisMobil; }
    public void setJenisMobil(String jenisMobil) { this.jenisMobil = jenisMobil; }
    public double getHargaMobil() { return hargaMobil; }
    public void setHargaMobil(double hargaMobil) { this.hargaMobil = hargaMobil; }
    public String getWarnaMobil() { return warnaMobil; }
    public void setWarnaMobil(String warnaMobil) { this.warnaMobil = warnaMobil; }
    public int getTahunProduksi() { return tahunProduksi; }
    public void setTahunProduksi(int tahunProduksi) { this.tahunProduksi = tahunProduksi; }
    public String getNegaraProduksi() { return negaraProduksi; }
    public void setNegaraProduksi(String negaraProduksi) { this.negaraProduksi = negaraProduksi; }
    
    // Getter dan Setter untuk atribut tambahan
    public String getAdditionalTechnology() { return additionalTechnology; }
    public void setAdditionalTechnology(String additionalTechnology) { this.additionalTechnology = additionalTechnology; }
    public String getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(String maxSpeed) { this.maxSpeed = maxSpeed; }
    public String getEngineType() { return engineType; }
    public void setEngineType(String engineType) { this.engineType = engineType; }

    @Override
    public String toString() {
        return "Mobil{" +
                "namaMobil='" + namaMobil + '\'' +
                ", brandMobil='" + brandMobil + '\'' +
                ", jenisMobil='" + jenisMobil + '\'' +
                ", hargaMobil=" + hargaMobil +
                ", warnaMobil='" + warnaMobil + '\'' +
                ", tahunProduksi=" + tahunProduksi +
                ", negaraProduksi='" + negaraProduksi + '\'' +
                ", idMobil=" + idMobil +
                ", customerId=" + customerId +
                '}';
    }
}

abstract class MobilBalap extends Mobil {
    public MobilBalap(String namaMobil, String brandMobil, String jenisMobil, double hargaMobil,
                      String warnaMobil, int tahunProduksi, String negaraProduksi) {
        super(namaMobil, brandMobil, jenisMobil, hargaMobil, warnaMobil, tahunProduksi, negaraProduksi);
    }

    // Getter dan Setter untuk atribut tambahan
    public abstract String getAdditionalInfo();

    @Override
    public String toString() {
        return super.toString() + getAdditionalInfo();
    }
}

class Supercar extends MobilBalap {
    private final String additionalTechnology; 

    public Supercar(String namaMobil, String brandMobil, double hargaMobil,
                        String warnaMobil, int tahunProduksi, String negaraProduksi,
                        String additionalTechnology) {
        super(namaMobil, brandMobil, "Supercar", hargaMobil, warnaMobil, tahunProduksi, negaraProduksi);
        this.additionalTechnology = additionalTechnology;
    }

    @Override
    public String getAdditionalInfo() {
        return ", additionalTechnology=" + additionalTechnology;
    }
}

class OpenWheelRacingCar extends MobilBalap {
    private final String maxSpeed; // Perubahan jenis variabel menjadi String

    public OpenWheelRacingCar(String namaMobil, String brandMobil, double hargaMobil,
                        String warnaMobil, int tahunProduksi, String negaraProduksi,
                        String maxSpeed) { // Perubahan tipe parameter menjadi String
        super(namaMobil, brandMobil, "Open wheel racing car", hargaMobil, warnaMobil, tahunProduksi, negaraProduksi);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getAdditionalInfo() {
        return ", maxSpeed=" + maxSpeed + " km/h";
    }
}

class SportsPrototype extends MobilBalap {
    private final String engineType; // Jenis mesin untuk Sports Prototype

    public SportsPrototype(String namaMobil, String brandMobil, double hargaMobil,
                        String warnaMobil, int tahunProduksi, String negaraProduksi,
                        String engineType) {
        super(namaMobil, brandMobil, "Sports Prototype", hargaMobil, warnaMobil, tahunProduksi, negaraProduksi);
        this.engineType = engineType;
    }

    @Override
    public String getAdditionalInfo() {
        return ", engineType=" + engineType;
    }
}

class Admin {
    private final String username;
    private final String password;
    
    // Konstruktor Admin tanpa parameter ID pelanggan
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String getUsername() {
        return username;
    }
}

class Customer {
    private final int customerId;
    private final  String username;
    private final String password;

    public Customer(int customerId, String username, String password) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Getter dan Setter
    public int getCustomerId() { return customerId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

public class PenjualanDataMobilSportsTOPSECRET {
    private final static Admin admin = new Admin("admin", "123");
    private final static ArrayList<Mobil> penyimpananMobilList = new ArrayList<>();
    private final static ArrayList<Mobil> pembelianMobilList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static Connection connection;
    
    public static void main(String[] args) {
        try {
            String server = "localhost";
            String userid = "root";
            String password = "";
            String database = "db_penjualanmobilsports";

            connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, userid, password);
            System.out.println("System Info :  Berhasil terhubung ke database.\n");
        } catch (SQLException e) {
            System.out.println("System Info : Gagal terhubung ke database: \n" + e.getMessage());
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>    WELCOME TO SPORT CARS TOPSECRET    <<\n ");

        int choice;
        do {
            displayMainMenu();

            System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4] :  ");
            String input = scanner.nextLine();

            // Memeriksa apakah input kosong
            if (input.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong.\n");
                continue; // Meminta input kembali
            }

            // Memeriksa apakah input adalah angka
            if (!input.matches("\\d+")) {
                System.out.println("Input harus berupa angka.\n");
                continue; // Meminta input kembali
            }

            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    loginAdmin(scanner);
                    break;
                case 2:
                    registerCustomer(scanner);
                    break;
                case 3:
                    loginCustomer(scanner);
                    break;
                case 4:
                    System.out.println("Program selesai, Terima Kasih Kerja Kerasnya Admin!!!.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        } while (true);
    }

    private static void displayMainMenu() {
        System.out.println("=".repeat(30) + "\n"
                + "|          Menu Utama:       |\n"
                + "=".repeat(30) + "\n"
                + "|  1. Login Admin            |\n"
                + "|  2. Register Customer      |\n"
                + "|  3. Login Customer         |\n"
                + "|  4. Keluar Program         |\n"
                + "=".repeat(30) + "\n"
                + ">>  Silakan pilih opsi: \n");
    }

    private static void loginAdmin(Scanner scanner) {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            int remainingAttempts = maxAttempts - attempts;
            System.out.println("\n" + "=".repeat(30) + "\n"
                    + "|     Menu Login Admin       |\n"
                    + "=".repeat(30) + "" );
            System.out.print("Masukkan Username Admin: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Masukkan Password Admin: ");
            String enteredPassword = scanner.nextLine();

            if (admin.login(enteredUsername, enteredPassword)) {
                String username = admin.getUsername(); 
                System.out.println("\nSystem : Selamat Datang Admin TopSecret Sport Cars.");
                menuAdmin(scanner, username, connection);
                return; // keluar dari metode setelah login berhasil
            } else {
                attempts++;
                remainingAttempts = maxAttempts - attempts;
                if (remainingAttempts > 0) {
                    System.out.println("\nLogin gagal. Username atau password salah.");
                    System.out.println("Kesempatan login tersisa: " + remainingAttempts + " kali.\n");
                } else {
                    System.out.println("Anda telah menggunakan semua kesempatan login.\n");
                    System.out.println("Kembali ke Menu Utama.\n");
                }
            }
        }
}

    private static void registerCustomer(Scanner scanner) {
        if (connection == null) {
            System.out.println("Koneksi database belum berhasil dibuat.");
            return;
        }

        System.out.println("\n" + "=".repeat(40) + "\n"
                    + "|       Pendaftaran Customer Baru      |\n"
                    + "=".repeat(40) + "");

        String newUsername;
        do {
            System.out.print("Masukkan username: ");
            newUsername = scanner.nextLine();

            // Memeriksa apakah username kosong
            if (newUsername.trim().isEmpty()) {
                System.out.println("Username tidak boleh kosong.\n");
            } else if (newUsername.equals("admin")) {
                System.out.println("Username 'admin' tidak boleh digunakan.\n");
            } else if (!newUsername.matches("^[a-zA-Z0-9 ]+$")) {
                System.out.println("Username hanya boleh terdiri dari huruf dan angka.\n");
            } else if (checkExistingUsername(newUsername)) {
                System.out.println("Username sudah digunakan. Silakan coba dengan username lain.\n");
            } else {
                break;
            }
        } while (true);

        System.out.print("Masukkan password: ");
        String newPassword = scanner.nextLine();

        // Memeriksa apakah password kosong
        if (newPassword.trim().isEmpty()) {
            System.out.println("Password tidak boleh kosong.\n");
            return;
        }

        // Memeriksa apakah password terdiri dari lebih dari 12 karakter
        if (newPassword.length() > 12) {
            System.out.println("Password tidak boleh lebih dari 12 karakter.\n");
            return;
        }

        try {
            String queryMaxId = "SELECT MAX(customer_id) AS max_id FROM tb_customers";
            Statement statementMaxId = connection.createStatement();
            ResultSet resultSet = statementMaxId.executeQuery(queryMaxId);

            int newCustomerId = 1;
            if (resultSet.next()) {
                int maxId = resultSet.getInt("max_id");
                if (maxId > 0) {
                    newCustomerId = maxId + 1;
                }
            }

            // Buat pernyataan SQL untuk menambahkan data ke dalam tabel tb_customers
            String query = "INSERT INTO tb_customers (customer_id, username_customers, password_customers) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newCustomerId);
            statement.setString(2, newUsername);
            statement.setString(3, newPassword);

            // Eksekusi pernyataan SQL
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer berhasil didaftarkan.");
                // Tambah customer baru ke dalam customerList
                customerList.add(new Customer(newCustomerId, newUsername, newPassword));
            } else {
                System.out.println("Gagal mendaftarkan customer,  sepertinya ada kesalahan. ");
            }

            // Setelah mendaftar, langsung login
            loginCustomer(scanner);
        } catch (SQLException e) {
            System.out.println("Error saat mendaftarkan customer, sepertinya ada kesalahan: " + e.getMessage());
        }
    }

    private static boolean checkExistingUsername(String username) {
        try {
            String query = "SELECT COUNT(*) FROM tb_customers WHERE username_customers = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error saat memeriksa username anda, sepertinya ada kesalahan: " + e.getMessage());
        }
        return false;
    }
    
    private static boolean checkCustomerLogin(String username, String password) {
        try {
            String query = "SELECT * FROM tb_customers WHERE username_customers = ? AND password_customers = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error saat memeriksa login customer: " + e.getMessage());
            return false;
        }
    }

   private static void loginCustomer(Scanner scanner) {
        String enteredUsername;
        System.out.println("\n" + "=".repeat(30) + "\n"
                + "|     Login Customer Akun    |\n"
                + "=".repeat(30) + "");

        do {
            System.out.print("Masukkan Username Akun Anda untuk Login: ");
            enteredUsername = scanner.nextLine();

            // Memeriksa apakah username kosong
            if (enteredUsername.trim().isEmpty()) {
                System.out.println("Username tidak boleh kosong.\n");
            } else if (!enteredUsername.matches("^[a-zA-Z0-9 ]+$")) {
                System.out.println("Username hanya boleh terdiri dari huruf dan angka.\n");
            } else if (enteredUsername.equals("admin")) {
                System.out.println("Username 'admin' tidak boleh digunakan.\n");
            } else {
                break;
            }
        } while (true);

        System.out.print("Masukkan Password Akun Anda untuk Login: ");
        String enteredPassword = scanner.nextLine();

        if (checkCustomerLogin(enteredUsername, enteredPassword)) {
            System.out.println("Customer Login berhasil.\n");
            int customerId = getCustomerIdByUsernameAndPassword(enteredUsername, enteredPassword);

            if (checkDataPribadiExist(customerId)) {
                menuCustomer(scanner, customerId);
            } else {
                tambahDataPribadiCustomer(scanner, customerId);
            }
        } else {
            System.out.println("Login gagal. Username atau password salah.\n");
        }
    }

    private static boolean checkDataPribadiExist(int customer_id) {
        try {
            String query = "SELECT * FROM tb_datacustomers WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customer_id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error saat memeriksa data pribadi: " + e.getMessage());
            return false;
        }
    }

    private static int getCustomerIdByUsernameAndPassword(String username, String password) {
        try {
            String query = "SELECT customer_id FROM tb_customers WHERE username_customers = ? AND password_customers = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("customer_id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Error saat mengambil customer_id: " + e.getMessage());
            return -1;
        }
    }

    private static void tambahDataPribadiCustomer(Scanner scanner, int customer_id) {
        System.out.println("\n" + "=".repeat(52) + "\n"
                + "|     Form Biodata Customer TOPSECRET SPORT CARS   |\n"
                + "=".repeat(52) + "");

        String nama;
        do {
            System.out.print("Masukkan Nama Anda: ");
            nama = scanner.nextLine().trim();

            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
            } else if (!nama.matches("^[a-zA-Z ]+$")) {
                System.out.println("Nama hanya boleh terdiri dari huruf dan spasi.");
            } else {
                break;
            }
        } while (true);

        int umur;
        do {
            System.out.print("Masukkan Umur Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Umur harus berupa angka.");
                scanner.next(); 
            }
            umur = scanner.nextInt();
            scanner.nextLine(); 

            if (umur < 17) {
                System.out.println("Anda tidak cukup umur untuk membeli mobil. Tanyakan pada orang tua Anda.");
            } else {
                break;
            }
        } while (true);

        String email;
        do {
            System.out.print("Masukkan Email Anda: ");
            email = scanner.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Email tidak boleh kosong.");
            } else if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
                System.out.println("Format email tidak valid. Email harus berakhir dengan '@gmail.com'.");
            } else {
                break;
            }
        } while (true);

        String negara;
        do {
            System.out.print("Masukkan Negara Anda: ");
            negara = scanner.nextLine().trim();

            if (negara.isEmpty()) {
                System.out.println("Negara tidak boleh kosong.");
            } else if (!negara.matches("^[a-zA-Z ]+$")) {
                System.out.println("Negara hanya boleh terdiri dari huruf dan spasi.");
            } else {
                break;
            }
        } while (true);

        int datacustomer_id = -1;
        if (checkDataPribadiExist(customer_id)) {
            System.out.println("Data pribadi Anda sudah ada.");
            menuCustomer(scanner, customer_id);
            return;
        }
        
        int maxDataCustomerId = 0; // Inisialisasi dengan 0

        String queryMaxDataCustomerId = "SELECT MAX(datacustomer_id) AS max_datacustomer_id FROM tb_datacustomers";
        try (Statement statementMaxDataCustomerId = connection.createStatement();
             ResultSet resultSetDataCustomerId = statementMaxDataCustomerId.executeQuery(queryMaxDataCustomerId)) {

            if (resultSetDataCustomerId.next()) {
                maxDataCustomerId = resultSetDataCustomerId.getInt("max_datacustomer_id");
            }
        } catch (SQLException e) {
            System.out.println("Error saat menjalankan query untuk memperoleh datacustomer_id terakhir: " + e.getMessage());
        }

        if (maxDataCustomerId == 0) {
            datacustomer_id = 1; // Jika tabel kosong, mulai dari 1
        } else {
            datacustomer_id = maxDataCustomerId + 1;
        }
        
        try {
            if (!checkDataPribadiExist(customer_id)) {
                datacustomer_id = 1;
            }

            String query = "INSERT INTO tb_datacustomers (customer_id, nama_customer, umur_customer, email_customer, negara_customer) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customer_id);
            statement.setString(2, nama);
            statement.setInt(3, umur);
            statement.setString(4, email);
            statement.setString(5, negara);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data pribadi Anda berhasil disimpan.");
                menuCustomer(scanner, customer_id);
            } else {
                System.out.println("Gagal menyimpan data pribadi.");
            }
        } catch (SQLException e) {
            System.out.println("Error saat menyimpan data pribadi: " + e.getMessage());
        }
    }
    
    private static void menuAdmin(Scanner scanner, String username, Connection connection) {
    int choice = 0; // Inisialisasi choice dengan nilai 0
    boolean validInput;
    do {
        System.out.println("\n====================================================\n" +
                           "|                 Menu Admin                       |\n" +
                           "====================================================\n" +
                           "|  Pilih Menu Admin:                               |\n" +
                           "|  1. Tambah Data Mobil                            |\n" +
                           "|  2. Lihat Data Mobil                             |\n" +
                           "|  3. Ubah Data Mobil                              |\n" +
                           "|  4. Hapus Data Mobil                             |\n" +
                           "|  5. Logout                                       |\n" +
                           "|  6. Exit Program                                 |\n" +
                           "====================================================");

        System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6]: ");
        do {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 6) {
                        validInput = true;
                    } else {
                        validInput = false;
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                        System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6]: ");
                    }
                } catch (NumberFormatException e) {
                    validInput = false;
                    System.out.println("Input harus berupa angka. Silakan pilih lagi.");
                    System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6]: ");
                }
            } else {
                validInput = false;
                System.out.println("Input tidak boleh kosong. Silakan pilih lagi.");
                System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6]: ");
            }
        } while (!validInput);

        switch (choice) {
            case 1:
                tambahDataMobil(scanner, connection);
                break;
            case 2:
                lihatDataMobil(connection);
                break;
            case 3:
                ubahDataMobil(scanner, connection);
                break;
            case 4:
                hapusDataMobil(scanner, connection);
                break;
            case 5:
                System.out.println("Logout berhasil.");
                return; 
            case 6:
                System.out.println("Program selesai.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.\n");
        }
    } while (true);
}

    private static void tambahDataMobil(Scanner scanner, Connection connection) {
        System.out.println("\n===================================================\n"
                         + "|           Menu Tambah Mobil Admin               |\n"
                         + "===================================================");

        String namaMobil = "";
        String brandMobil = "";
        String jenisMobil = "";
        double hargaMobil = 0;
        String warnaMobil = "";
        int tahunProduksi = 0;
        String negaraProduksi = "";
        String spesifikasiKhusus = "";

        // Input Nama Mobil dengan error handling
        while (namaMobil.isEmpty() || !namaMobil.matches("[a-zA-Z0-9 ]*")) {
            System.out.print("Nama Mobil: ");
            namaMobil = scanner.nextLine().trim();
            if (namaMobil.isEmpty()) {
                System.out.println("Nama mobil tidak boleh kosong.");
            } else if (!namaMobil.matches("[a-zA-Z0-9 ]*")) {
                System.out.println("Nama mobil hanya boleh mengandung huruf, angka, atau spasi.");
            }
        }

        // Input Brand Mobil dengan error handling
        while (brandMobil.isEmpty() || !brandMobil.matches("[a-zA-Z0-9 ]*")) {
            System.out.print("Brand Mobil: ");
            brandMobil = scanner.nextLine().trim();
            if (brandMobil.isEmpty()) {
                System.out.println("Brand mobil tidak boleh kosong.");
            } else if (!brandMobil.matches("[a-zA-Z0-9 ]*")) {
                System.out.println("Brand mobil hanya boleh mengandung huruf, angka, atau spasi.");
            }
        }

        while (jenisMobil.isEmpty() || !jenisMobil.matches("[a-zA-Z ]*") || 
            !(jenisMobil.equalsIgnoreCase("supercar") || jenisMobil.equalsIgnoreCase("open wheel racing car") || jenisMobil.equalsIgnoreCase("sports prototype"))) {
            System.out.print("Jenis Mobil (supercar/open wheel racing car/sports prototype): ");
            jenisMobil = scanner.nextLine().trim().toLowerCase(); 
            if (jenisMobil.isEmpty()) {
                System.out.println("Jenis mobil tidak boleh kosong.");
            } else if (!jenisMobil.matches("[a-zA-Z ]*")) {
                System.out.println("Jenis mobil hanya boleh mengandung huruf atau spasi.");
            } else if (!(jenisMobil.equalsIgnoreCase("supercar") || jenisMobil.equalsIgnoreCase("open wheel racing car") || jenisMobil.equalsIgnoreCase("sports prototype"))) {
                System.out.println("Jenis mobil tidak valid. Silakan masukkan jenis mobil yang sesuai.");
            }
        }

        // Input Harga Mobil dengan error handling
        boolean hargaValid = false;
        while (!hargaValid) {
            System.out.print("Harga Mobil: ");
            String hargaInput = scanner.nextLine().trim();
            try {
                hargaMobil = Double.parseDouble(hargaInput);
                if (hargaMobil <= 0) {
                    System.out.println("Harga mobil tidak boleh nol atau negatif.");
                } else {
                    hargaValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Harga mobil harus berupa angka.");
            }
        }

        // Input Warna Mobil dengan error handling
        while (warnaMobil.isEmpty() || !warnaMobil.matches("[a-zA-Z ]*")) {
            System.out.print("Warna Mobil: ");
            warnaMobil = scanner.nextLine().trim();
            if (warnaMobil.isEmpty()) {
                System.out.println("Warna mobil tidak boleh kosong.");
            } else if (!warnaMobil.matches("[a-zA-Z ]*")) {
                System.out.println("Warna mobil hanya boleh mengandung huruf atau spasi.");
            }
        }

        // Input Tahun Produksi dengan error handling
        boolean tahunValid = false;
        while (!tahunValid) {
            System.out.print("Tahun Produksi: ");
            String tahunInput = scanner.nextLine().trim();
            try {
                if (tahunInput.length() != 4) {
                    throw new IllegalArgumentException("Tahun produksi harus terdiri dari 4 digit.");
                }
                tahunProduksi = Integer.parseInt(tahunInput);
                tahunValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Tahun produksi harus berupa angka.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input Negara Produksi dengan error handling
        while (negaraProduksi.isEmpty() || negaraProduksi.matches(".*\\d.*")) {
            System.out.print("Negara Produksi: ");
            negaraProduksi = scanner.nextLine().trim();
            if (negaraProduksi.isEmpty()) {
                System.out.println("Negara produksi tidak boleh kosong.");
            } else if (negaraProduksi.matches(".*\\d.*")) {
                System.out.println("Negara produksi tidak boleh mengandung angka.");
            }
        }

        // Input Spesifikasi Khusus dengan error handling
        boolean spesifikasiValid = false;
        while (!spesifikasiValid) {
            if (jenisMobil.equalsIgnoreCase("supercar")) {
                System.out.print("Teknologi Tambahan: ");
            } else if (jenisMobil.equalsIgnoreCase("open wheel racing car")) {
                System.out.print("Maksimum Kecepatan (km/h): ");
            } else if (jenisMobil.equalsIgnoreCase("sports prototype")) {
                System.out.print("Jenis Mesin: ");
            }

            spesifikasiKhusus = scanner.nextLine().trim();
            if (jenisMobil.equalsIgnoreCase("open wheel racing car")) {
                try {
                    double kecepatan = Double.parseDouble(spesifikasiKhusus);
                    if (kecepatan <= 0) {
                        System.out.println("Maksimum kecepatan harus lebih besar dari nol.");
                    } else {
                        spesifikasiValid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Maksimum kecepatan harus berupa angka.");
                }
            } else {
                spesifikasiValid = true;
            }
        }

        // Simpan data mobil ke dalam tabel tb_mobil
        try {
            String query;
            if (jenisMobil.equalsIgnoreCase("Supercar")) {
                query = "INSERT INTO tb_mobil (nama_mobil, brand_mobil, jenis_mobil, harga_mobil, warna_mobil, tahun_produksi, negara_produksi, additional_technology) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            } else if (jenisMobil.equalsIgnoreCase("Open wheel racing car")) {
                query = "INSERT INTO tb_mobil (nama_mobil, brand_mobil, jenis_mobil, harga_mobil, warna_mobil, tahun_produksi, negara_produksi, max_speed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            } else if (jenisMobil.equalsIgnoreCase("Sports Prototype")) {
                query = "INSERT INTO tb_mobil (nama_mobil, brand_mobil, jenis_mobil, harga_mobil, warna_mobil, tahun_produksi, negara_produksi, engine_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            } else {
                System.out.println("Jenis mobil tidak valid.");
                return;
            }

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, namaMobil);
                statement.setString(2, brandMobil);
                statement.setString(3, jenisMobil);
                statement.setDouble(4, hargaMobil);
                statement.setString(5, warnaMobil);
                statement.setInt(6, tahunProduksi);
                statement.setString(7, negaraProduksi);

                // Menyesuaikan nilai parameter berdasarkan jenis mobil
                if (jenisMobil.equalsIgnoreCase("supercar")) {
                    statement.setString(8, spesifikasiKhusus);
                } else if (jenisMobil.equalsIgnoreCase("open wheel racing car")) {
                    statement.setDouble(8, Double.parseDouble(spesifikasiKhusus));
                } else if (jenisMobil.equalsIgnoreCase("sports prototype")) {
                    statement.setString(8, spesifikasiKhusus);
                }

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data mobil berhasil ditambahkan ke database.");

                    // Set ulang auto increment pada id_mobil
                    resetAutoIncrementIdMobil(connection);
                } else {
                    System.out.println("Gagal menambahkan data mobil ke database.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data mobil: " + e.getMessage());
        }
    }

    private static void resetAutoIncrementIdMobil(Connection connection) {
    try {
        // Mengambil nilai maksimum id_mobil dari tabel
        String queryMaxId = "SELECT MAX(id_mobil) AS max_id FROM tb_mobil";
        int newAutoIncrementValue = 0;

        try (PreparedStatement statementMaxId = connection.prepareStatement(queryMaxId)) {
            ResultSet resultSetMaxId = statementMaxId.executeQuery();

            if (resultSetMaxId.next()) {
                // Mendapatkan nilai maksimum id_mobil
                int maxId = resultSetMaxId.getInt("max_id");
                // Menambah 1 untuk mendapatkan nilai baru untuk auto increment
                newAutoIncrementValue = maxId + 1;
            }
        }

        // Mengatur ulang auto increment pada id_mobil
        String queryResetAutoIncrement = "ALTER TABLE tb_mobil AUTO_INCREMENT = ?";
        try (PreparedStatement statementResetAutoIncrement = connection.prepareStatement(queryResetAutoIncrement)) {
            statementResetAutoIncrement.setInt(1, newAutoIncrementValue);
            statementResetAutoIncrement.executeUpdate();
        }

        System.out.println("Auto increment id_mobil berhasil diatur ulang.");

    } catch (SQLException e) {
        System.out.println("Terjadi kesalahan saat mereset auto increment id_mobil: " + e.getMessage());
    }
}

    private static void lihatDataMobil(Connection connection) {
    System.out.println("\n==================================================================");
    System.out.println("|                           DATA MOBIL                           |");
    System.out.println("==================================================================");

    try {
        // Buat statement untuk mengambil data mobil dari tb_mobil
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM tb_mobil";
        ResultSet resultSet = statement.executeQuery(query);

        // Tampilkan data mobil
        while (resultSet.next()) {
            System.out.println("|    ID Mobil: " + resultSet.getInt("id_mobil"));
            System.out.println("|    Nama Mobil: " + resultSet.getString("nama_mobil"));
            System.out.println("|    Brand Mobil: " + resultSet.getString("brand_mobil"));
            System.out.println("|    Jenis Mobil: " + resultSet.getString("jenis_mobil"));
            System.out.println("|    Harga Mobil: " + resultSet.getDouble("harga_mobil"));
            System.out.println("|    Warna Mobil: " + resultSet.getString("warna_mobil"));
            System.out.println("|    Tahun Produksi: " + resultSet.getInt("tahun_produksi"));
            System.out.println("|    Negara Produksi: " + resultSet.getString("negara_produksi"));

            // Menampilkan atribut tambahan sesuai dengan jenis mobil
            if (resultSet.getString("jenis_mobil").equalsIgnoreCase("supercar")) {
                System.out.println("|    Teknologi Tambahan: " + resultSet.getString("additional_technology"));
            } else if (resultSet.getString("jenis_mobil").equalsIgnoreCase("open wheel racing car")) {
                System.out.println("|    Maksimum Kecepatan: " + resultSet.getDouble("max_speed") + " km/h");
            } else if (resultSet.getString("jenis_mobil").equalsIgnoreCase("sports prototype")) {
                System.out.println("|    Jenis Mesin: " + resultSet.getString("engine_type"));
            }
            System.out.println("==================================================================");
        }

        // Tutup statement dan result set
        statement.close();
        resultSet.close();
    } catch (SQLException e) {
        System.out.println("Terjadi kesalahan saat mengambil data mobil: " + e.getMessage());
    }
}

private static void ubahDataMobil(Scanner scanner, Connection connection) {
    System.out.println("\nUbah Data Mobil");

    // Menampilkan daftar mobil
    lihatDataMobil(connection);

    System.out.print("Masukkan nomor mobil yang ingin diubah: ");
    int mobilIndex;
    try {
        mobilIndex = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Nomor mobil tidak valid.");
        return;
    }

    try {
        String query = "SELECT * FROM tb_mobil LIMIT ?, 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, mobilIndex - 1);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int idMobil = resultSet.getInt("id_mobil");  
            Mobil mobil = new Mobil(
                    resultSet.getString("nama_mobil"),
                    resultSet.getString("brand_mobil"),
                    resultSet.getString("jenis_mobil"),
                    resultSet.getDouble("harga_mobil"),
                    resultSet.getString("warna_mobil"),
                    resultSet.getInt("tahun_produksi"),
                    resultSet.getString("negara_produksi")
            );

            // Menyesuaikan atribut tambahan sesuai dengan jenis mobil
            if (mobil instanceof Supercar) {
                ((Supercar) mobil).setAdditionalTechnology(resultSet.getString("additional_technology"));
            } else if (mobil instanceof OpenWheelRacingCar) {
                ((OpenWheelRacingCar) mobil).setMaxSpeed(resultSet.getString("max_speed"));
            } else if (mobil instanceof SportsPrototype) {
                ((SportsPrototype) mobil).setEngineType(resultSet.getString("engine_type"));
            }

            // Meminta input pengguna untuk memperbarui data mobil
            System.out.println("\nMasukkan data baru (kosongkan jika tidak ingin mengubah):");

            System.out.print("Nama Mobil [" + mobil.getNamaMobil() + "]: ");
            String namaMobilBaru = scanner.nextLine().trim();
            if (namaMobilBaru.isEmpty()) {
                namaMobilBaru = mobil.getNamaMobil();
            }

            System.out.print("Brand Mobil [" + mobil.getBrandMobil() + "]: ");
            String brandMobilBaru = scanner.nextLine().trim();
            if (brandMobilBaru.isEmpty()) {
                brandMobilBaru = mobil.getBrandMobil();
            }

            System.out.print("Jenis Mobil (supercar/open wheel racing car/sports prototype) [" + mobil.getJenisMobil() + "]: ");
            String jenisMobilBaru = scanner.nextLine().trim();
            if (jenisMobilBaru.isEmpty()) {
                jenisMobilBaru = mobil.getJenisMobil();
            }

            System.out.print("Harga Mobil [" + mobil.getHargaMobil() + "]: ");
            String hargaInput = scanner.nextLine().trim();
            double hargaMobilBaru = mobil.getHargaMobil();
            if (!hargaInput.isEmpty()) {
                try {
                    hargaMobilBaru = Double.parseDouble(hargaInput);
                } catch (NumberFormatException e) {
                    System.out.println("Harga mobil harus berupa angka.");
                    return;
                }
            }

            System.out.print("Warna Mobil [" + mobil.getWarnaMobil() + "]: ");
            String warnaMobilBaru = scanner.nextLine().trim();
            if (warnaMobilBaru.isEmpty()) {
                warnaMobilBaru = mobil.getWarnaMobil();
            }

            System.out.print("Tahun Produksi [" + mobil.getTahunProduksi() + "]: ");
            String tahunInput = scanner.nextLine().trim();
            int tahunProduksiBaru = mobil.getTahunProduksi();
            if (!tahunInput.isEmpty()) {
                try {
                    tahunProduksiBaru = Integer.parseInt(tahunInput);
                    if (tahunInput.length() != 4) {
                        System.out.println("Tahun produksi harus terdiri dari 4 digit.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Tahun produksi harus berupa angka.");
                    return;
                }
            }

            System.out.print("Negara Produksi [" + mobil.getNegaraProduksi() + "]: ");
            String negaraProduksiBaru = scanner.nextLine().trim();
            if (negaraProduksiBaru.isEmpty()) {
                negaraProduksiBaru = mobil.getNegaraProduksi();
            }

            String spesifikasiKhusus = "";
            String spesifikasiQuery = "";
            if (jenisMobilBaru.equalsIgnoreCase("supercar")) {
                System.out.print("Teknologi Tambahan: ");
                spesifikasiKhusus = scanner.nextLine().trim();
                spesifikasiQuery = "additional_technology = ?";
            } else if (jenisMobilBaru.equalsIgnoreCase("open wheel racing car")) {
                System.out.print("Maksimum Kecepatan (km/h): ");
                spesifikasiKhusus = scanner.nextLine().trim();
                spesifikasiQuery = "max_speed = ?";
            } else if (jenisMobilBaru.equalsIgnoreCase("sports prototype")) {
                System.out.print("Jenis Mesin: ");
                spesifikasiKhusus = scanner.nextLine().trim();
                spesifikasiQuery = "engine_type = ?";
            }

            // Membuat dan menyiapkan pernyataan SQL untuk update data mobil
            String updateQuery = "UPDATE tb_mobil SET nama_mobil = ?, brand_mobil = ?, jenis_mobil = ?, harga_mobil = ?, warna_mobil = ?, tahun_produksi = ?, negara_produksi = ?" + (spesifikasiQuery.isEmpty() ? "" : ", " + spesifikasiQuery) + " WHERE id_mobil = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, namaMobilBaru);
            updateStatement.setString(2, brandMobilBaru);
            updateStatement.setString(3, jenisMobilBaru);
            updateStatement.setDouble(4, hargaMobilBaru);
            updateStatement.setString(5, warnaMobilBaru);
            updateStatement.setInt(6, tahunProduksiBaru);
            updateStatement.setString(7, negaraProduksiBaru);
            if (!spesifikasiQuery.isEmpty()) {
                updateStatement.setString(8, spesifikasiKhusus);
                updateStatement.setInt(9, idMobil); 
            } else {
                updateStatement.setInt(8, idMobil);
            }

            // Menjalankan pernyataan update
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data mobil berhasil diubah.");
            } else {
                System.out.println("Gagal mengubah data mobil.");
            }

            // Tutup statement dan result set
            statement.close();
            resultSet.close();
        } else {
            System.out.println("Nomor mobil tidak valid.");
        }
    } catch (SQLException e) {
        System.out.println("Terjadi kesalahan saat mengubah data mobil: " + e.getMessage());
    }
}

private static void hapusDataMobil(Scanner scanner, Connection connection) {
    System.out.println("\nHapus Data Mobil");

    // Menampilkan daftar mobil
    lihatDataMobil(connection);

    System.out.print("Pilih nomor mobil yang akan dihapus: ");
    int mobilIndex;
    try {
        mobilIndex = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Nomor mobil tidak valid.");
        return;
    }

    try {
        String query = "DELETE FROM tb_mobil WHERE nama_mobil = (SELECT nama_mobil FROM tb_mobil LIMIT ?, 1)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, mobilIndex - 1);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Data mobil berhasil dihapus dari database.");
        } else {
            System.out.println("Gagal menghapus data mobil dari database.");
        }

        // Tutup statement
        statement.close();
    } catch (SQLException e) {
        System.out.println("Terjadi kesalahan saat menghapus data mobil: " + e.getMessage());
    }
}



            private static void menuCustomer(Scanner scanner, int customer_id) {
                int choice = 0; 
                boolean validInput;
                do {
                System.out.println("\n====================================================\n" +
                               "|                 Menu Customer                    |\n" +
                               "====================================================\n" +
                               "|  Pilih Menu Customer:                            |\n" +
                               "|  1. Tambah Pembelian Mobil ke Daftar             |\n" +
                               "|  2. Lihat Mobil dalam Daftar Sebelum di Beli     |\n" +
                               "|  3. Lihat Pembelian Mobil                        |\n" +
                               "|  4. Ubah Pembelian Mobil ke Daftar               |\n" +
                               "|  5. Hapus Pembelian Mobil ke Daftar              |\n" +
                               "|  6. Beli Mobil                                   |\n" +
                               "|  7. Riwayat Pembelian                            |\n" +
                               "|  8. Logout                                       |\n" +
                               "|  9. Exit Program                                 |\n" +
                               "====================================================");

                    System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6, 7, 8, 9] : ");
                    do {
                        String input = scanner.nextLine().trim();
                        if (!input.isEmpty()) {
                            try {
                                choice = Integer.parseInt(input);
                                if (choice >= 1 && choice <= 9) {
                                    validInput = true;
                                } else {
                                    validInput = false;
                                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                                    System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6, 7, 8, 9] : ");
                                }
                            } catch (NumberFormatException e) {
                                validInput = false;
                                System.out.println("Input harus berupa angka. Silakan pilih lagi.");
                                System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6, 7, 8, 9] : ");
                            }
                        } else {
                            validInput = false;
                            System.out.println("Input tidak boleh kosong. Silakan pilih lagi.");
                            System.out.print("Masukkan Pilihan Menu Anda [1, 2, 3, 4, 5, 6, 7, 8, 9] : ");
                        }
                    } while (!validInput);

                    switch (choice) {
                        case 1:
                            tambahPembelianMobil(scanner,  connection);
                            break;
                        case 2:
                            lihatListMobil();
                            break;   
                        case 3:
                            lihatPembelianMobil();
                            break;
                        case 4:
                            ubahPembelianMobil(scanner, connection);
                            break;
                        case 5:
                            hapusPembelianMobil(scanner);
                            break;
                        case 6:
                            BeliMobil.beliMobil(scanner, customer_id, connection, penyimpananMobilList, pembelianMobilList);
                            break;
                        case 7: 
                            RiwayatPembelian.lihatRiwayatPembelian(connection, customer_id);
                            break;
                        case 8:
                            System.out.println("Logout berhasil.");
                            return;
                        case 9:
                            System.out.println("Program selesai.");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    }
                } while (choice != 9);
            }

private static void tambahPembelianMobil(Scanner scanner, Connection connection) {
    System.out.println("\nPilihlah mobil yang paling Anda sukai, TopSecret menyediakan yang terbaik di sini!");

    // Menampilkan daftar mobil yang tersedia
    lihatDataMobil(connection);

    // Meminta input ID mobil dari pengguna
    System.out.print("Masukkan ID mobil yang akan dibeli: ");
    int idMobil = scanner.nextInt();
    scanner.nextLine(); 

    try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM TB_MOBIL WHERE id_mobil = ?");
        statement.setInt(1, idMobil);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Membuat objek mobil dari hasil query
            String namaMobil = resultSet.getString("nama_mobil");
            String brandMobil = resultSet.getString("brand_mobil");
            String jenisMobil = resultSet.getString("jenis_mobil").toLowerCase();
            double hargaMobil = resultSet.getDouble("harga_mobil");
            String warnaMobil = resultSet.getString("warna_mobil");
            int tahunProduksi = resultSet.getInt("tahun_produksi");
            String negaraProduksi = resultSet.getString("negara_produksi");

            // Inisialisasi objek mobil terpilih sesuai dengan jenisnya
            Mobil mobilTerpilih = null;
            switch (jenisMobil) {
                case "supercar":
                    String additionalTechnology = resultSet.getString("additional_technology");
                    mobilTerpilih = new Supercar(namaMobil, brandMobil, hargaMobil, warnaMobil, tahunProduksi, negaraProduksi, additionalTechnology);
                    break;
                case "open wheel racing car":
                    String maxSpeed = resultSet.getString("max_speed"); 
                    mobilTerpilih = new OpenWheelRacingCar(namaMobil, brandMobil, hargaMobil, warnaMobil, tahunProduksi, negaraProduksi, maxSpeed);
                    break;
                case "sports prototype":
                    String engineType = resultSet.getString("engine_type");
                    mobilTerpilih = new SportsPrototype(namaMobil, brandMobil, hargaMobil, warnaMobil, tahunProduksi, negaraProduksi, engineType);
                    break;
                default:
                    System.out.println("Jenis mobil \"" + jenisMobil + "\" tidak dikenali.");
                    return; 
            }

            // Tambahkan mobil ke dalam daftar pembelian
            penyimpananMobilList.add(mobilTerpilih);
            System.out.println("Pembelian mobil berhasil ditambahkan.");
        } else {
            System.out.println("ID mobil tidak valid.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private static void lihatListMobil() {
    System.out.println("\nLihat List Mobil sebelum Pembelian\n" +
            "======================================\n" +
            "|          DAFTAR LIST MOBIL         |\n" +
            "======================================");
    // Tampilkan data mobil dari penyimpananMobilList
    if (penyimpananMobilList.isEmpty()) {
        System.out.println("Tidak ada mobil tersedia.");
    } else {
        for (int i = 0; i < penyimpananMobilList.size(); i++) {
            Mobil mobil = penyimpananMobilList.get(i);
            System.out.println("|  [ " + (i + 1) + " ]  " + mobil.getNamaMobil() + "   |");
            System.out.println("|    Brand Mobil: " + mobil.getBrandMobil());
            String jenisMobilLower = mobil.getJenisMobil().toLowerCase();
            System.out.println("|    Jenis Mobil: " + jenisMobilLower);
            System.out.println("|    Harga Mobil: " + mobil.getHargaMobil());
            System.out.println("|    Warna Mobil: " + mobil.getWarnaMobil());
            System.out.println("|    Tahun Produksi: " + mobil.getTahunProduksi());
            System.out.println("|    Negara Produksi: " + mobil.getNegaraProduksi());
        }
    }
    System.out.println("======================================");
}

        private static void lihatPembelianMobil() {
    System.out.println("\nLihat Daftar Pembelian Mobil\n" +
            "======================================\n" +
            "|         DAFTAR PEMBELIAN MOBIL         |\n" +
            "======================================");
    
    // Akses langsung variabel pembelianMobilList dari kelas PenjualanDataMobilSportsTOPSECRET
    if (PenjualanDataMobilSportsTOPSECRET.pembelianMobilList.isEmpty()) {
        System.out.println("Tidak ada pembelian mobil.");
    } else {
        for (int i = 0; i < PenjualanDataMobilSportsTOPSECRET.pembelianMobilList.size(); i++) {
            Mobil mobil = PenjualanDataMobilSportsTOPSECRET.pembelianMobilList.get(i);
            System.out.println("|  [ " + (i + 1) + " ]  " + mobil.getNamaMobil() + "   |");
            System.out.println("|    Brand Mobil: " + mobil.getBrandMobil());
            System.out.println("|    Jenis Mobil: " + mobil.getJenisMobil());
            System.out.println("|    Harga Mobil: " + mobil.getHargaMobil());
            System.out.println("|    Warna Mobil: " + mobil.getWarnaMobil());
            System.out.println("|    Tahun Produksi: " + mobil.getTahunProduksi());
            System.out.println("|    Negara Produksi: " + mobil.getNegaraProduksi());
            if (mobil.getJenisMobil().equalsIgnoreCase("supercar")) {
                System.out.println("|    Additional Technology: " + mobil.getAdditionalTechnology());
            } else if (mobil.getJenisMobil().equalsIgnoreCase("open wheel racing car")) {
                System.out.println("|    Max Speed (km/h): " + ((OpenWheelRacingCar) mobil).getMaxSpeed());
            } else if (mobil.getJenisMobil().equalsIgnoreCase("sports prototype")) {
                System.out.println("|    Engine Type: " + ((SportsPrototype) mobil).getEngineType());
            }
        }
    }
    System.out.println("======================================");
}

private static void ubahPembelianMobil(Scanner scanner, Connection connection) {
    System.out.println("\nUbah Pembelian Mobil");

    // Menampilkan daftar pembelian mobil dari penyimpananMobilList
    System.out.println("\nDaftar Pembelian Mobil:");
    for (int i = 0; i < penyimpananMobilList.size(); i++) {
        Mobil mobil = penyimpananMobilList.get(i);
        System.out.println("==================================================================");
        System.out.println("|  [ " + (i + 1) + " ]  " + mobil.getNamaMobil() + "   |");
        System.out.println("|    Brand Mobil: " + mobil.getBrandMobil());
        System.out.println("|    Jenis Mobil: " + mobil.getJenisMobil());
        System.out.println("|    Harga Mobil: " + mobil.getHargaMobil());
        System.out.println("|    Warna Mobil: " + mobil.getWarnaMobil());
        System.out.println("|    Tahun Produksi: " + mobil.getTahunProduksi());
        System.out.println("|    Negara Produksi: " + mobil.getNegaraProduksi());
        if (mobil.getJenisMobil().equalsIgnoreCase("supercar")) {
            System.out.println("|    Additional Technology: " + mobil.getAdditionalTechnology());
        } else if (mobil.getJenisMobil().equalsIgnoreCase("open wheel racing car")) {
            System.out.println("|    Max Speed (km/h): " + ((OpenWheelRacingCar) mobil).getMaxSpeed());
        } else if (mobil.getJenisMobil().equalsIgnoreCase("sports prototype")) {
            System.out.println("|    Engine Type: " + ((SportsPrototype) mobil).getEngineType());
        }
        System.out.println("==================================================================");
    }

    System.out.print("Masukkan nomor pembelian yang ingin diubah: ");
    int pembelianIndex;
    try {
        pembelianIndex = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Nomor pembelian tidak valid.");
        return;
    }

    if (pembelianIndex < 1 || pembelianIndex > penyimpananMobilList.size()) {
        System.out.println("Nomor pembelian tidak valid.");
        return;
    }

    // Menampilkan data mobil yang tersedia di database
    lihatDataMobil(connection);

    System.out.print("Masukkan ID mobil pengganti: ");
    int idMobilPengganti;
    try {
        idMobilPengganti = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("ID mobil tidak valid.");
        return;
    }

    try {
        String query = "SELECT * FROM tb_mobil WHERE id_mobil = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idMobilPengganti);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String namaMobilPengganti = resultSet.getString("nama_mobil");
            
            // Periksa apakah mobil pengganti sudah ada di dalam daftar pembelian berdasarkan nama mobil
            for (Mobil mobil : penyimpananMobilList) {
                if (mobil.getNamaMobil().equalsIgnoreCase(namaMobilPengganti)) {
                    System.out.println("Data mobil tersebut sudah ada di dalam daftar pembelian.");
                    return;
                }
            }

            Mobil mobilPengganti;
            // Inisialisasi objek mobil pengganti sesuai dengan jenisnya
            String jenisMobilPengganti = resultSet.getString("jenis_mobil");
            if (jenisMobilPengganti.equalsIgnoreCase("supercar")) {
                mobilPengganti = new Supercar(
                        resultSet.getString("nama_mobil"),
                        resultSet.getString("brand_mobil"),
                        resultSet.getDouble("harga_mobil"),
                        resultSet.getString("warna_mobil"),
                        resultSet.getInt("tahun_produksi"),
                        resultSet.getString("negara_produksi"),
                        resultSet.getString("additional_technology")
                );
            } else if (jenisMobilPengganti.equalsIgnoreCase("open wheel racing car")) {
                mobilPengganti = new OpenWheelRacingCar(
                        resultSet.getString("nama_mobil"),
                        resultSet.getString("brand_mobil"),
                        resultSet.getDouble("harga_mobil"),
                        resultSet.getString("warna_mobil"),
                        resultSet.getInt("tahun_produksi"),
                        resultSet.getString("negara_produksi"),
                        resultSet.getString("max_speed")
                );
            } else if (jenisMobilPengganti.equalsIgnoreCase("sports prototype")) {
                mobilPengganti = new SportsPrototype(
                        resultSet.getString("nama_mobil"),
                        resultSet.getString("brand_mobil"),
                        resultSet.getDouble("harga_mobil"),
                        resultSet.getString("warna_mobil"),
                        resultSet.getInt("tahun_produksi"),
                        resultSet.getString("negara_produksi"),
                        resultSet.getString("engine_type")
                );
            } else {
                System.out.println("Jenis mobil pengganti tidak valid.");
                return;
            }

            // Mengubah data pembelian mobil di penyimpananMobilList
            penyimpananMobilList.set(pembelianIndex - 1, mobilPengganti);
            System.out.println("Data pembelian mobil berhasil diubah.");
        } else {
            System.out.println("ID mobil pengganti tidak ditemukan.");
        }

        // Tutup statement dan result set
        statement.close();
        resultSet.close();
    } catch (SQLException e) {
        System.out.println("Terjadi kesalahan saat mengambil data mobil:\n" + e.getMessage());
    }
}

private static void hapusPembelianMobil(Scanner scanner) {
    System.out.println("\nHapus Pembelian Mobil");

    if (!penyimpananMobilList.isEmpty()) {
        // Menampilkan daftar pembelian mobil dari penyimpananMobilList
        System.out.println("\nDaftar Pembelian Mobil:");
        for (int i = 0; i < penyimpananMobilList.size(); i++) {
            Mobil mobil = penyimpananMobilList.get(i);
            System.out.println("==================================================================");
            System.out.println("|  [ " + (i + 1) + " ]  " + mobil.getNamaMobil() + "   |");
            System.out.println("|    Brand Mobil: " + mobil.getBrandMobil());
            System.out.println("|    Jenis Mobil: " + mobil.getJenisMobil());
            System.out.println("|    Harga Mobil: " + mobil.getHargaMobil());
            System.out.println("|    Warna Mobil: " + mobil.getWarnaMobil());
            System.out.println("|    Tahun Produksi: " + mobil.getTahunProduksi());
            System.out.println("|    Negara Produksi: " + mobil.getNegaraProduksi());
            if (mobil.getJenisMobil().equalsIgnoreCase("supercar")) {
                System.out.println("|    Teknologi Tambahan: " + mobil.getAdditionalTechnology());
            } else if (mobil.getJenisMobil().equalsIgnoreCase("open wheel racing car")) {
                System.out.println("|    Maksimum Kecepatan (km/h): " + mobil.getMaxSpeed());
            } else if (mobil.getJenisMobil().equalsIgnoreCase("sports prototype")) {
                System.out.println("|    Jenis Mesin: " + mobil.getEngineType());
            }
            System.out.println("==================================================================");
        }

        System.out.print("Masukkan nomor mobil admin yang akan dihapus:");
        int nomorMobilAdmin = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi karakter newline

        if (nomorMobilAdmin >= 1 && nomorMobilAdmin <= penyimpananMobilList.size()) {
            // Menghapus mobil admin dari penyimpanan
            penyimpananMobilList.remove(nomorMobilAdmin - 1);
            System.out.println("Data mobil admin berhasil dihapus.\n");
        } else {
            System.out.println("Nomor mobil admin tidak valid.\n");
        }
    } else {
        System.out.println("Penyimpanan mobil kosong.\n");
    }
}

public class BeliMobil {

    public BeliMobil() {
        // Constructor
    }

    public static void beliMobil(Scanner scanner, int customer_id, Connection connection, ArrayList<Mobil> penyimpananMobilList, ArrayList<Mobil> pembelianMobilList) {
        tampilkanDataMobil(penyimpananMobilList);

        boolean lanjutPembelian = konfirmasiPembelian(scanner);

        if (lanjutPembelian) {
            pembelianMobilList.addAll(penyimpananMobilList);

            double totalHarga = pembelianMobilList.stream().mapToDouble(Mobil::getHargaMobil).sum();
            System.out.printf("Total Harga: %.2f%n", totalHarga);

            tampilkanStrukPembelian(pembelianMobilList);

            try {
                simpanKeDatabase(pembelianMobilList, customer_id, connection);
                hapusDariTabelMobil(pembelianMobilList, connection);
                hapusDariPenyimpananMobilList(pembelianMobilList, penyimpananMobilList);
                System.out.println("\nSystem : Data pembelian mobil berhasil disimpan ke database, dihapus dari tb_mobil, dan dihapus dari penyimpananMobilList.");
            } catch (SQLException e) {
                System.err.println("Gagal menyimpan ke database: " + e.getMessage());
            }
        } else {
            System.out.println("Pembelian dibatalkan.");
        }
    }

public static void tampilkanDataMobil(ArrayList<Mobil> penyimpananMobilList) {
    String garis = repeat("=", 120); 
    System.out.println(garis);
    System.out.println("|                                                      DATA MOBIL                                                      |");
    System.out.println(garis);
    System.out.printf("| %-20s | %-15s | %-20s | %-10s | %-8s | %-15s | %-10s |%n",
            "Nama Mobil", "Brand", "Jenis", "Harga", "Warna", "Tahun Produksi", "Negara");
    System.out.println(garis);
    
    for (Mobil mobil : penyimpananMobilList) {
        System.out.printf("| %-20s | %-15s | %-20s | %-10.2f | %-8s | %-15d | %-10s |%n",
                mobil.getNamaMobil(), mobil.getBrandMobil(), mobil.getJenisMobil(),
                mobil.getHargaMobil(), mobil.getWarnaMobil(), mobil.getTahunProduksi(), mobil.getNegaraProduksi());
    }
    
    System.out.println(garis);
}

    public static String repeat(String str, int count) {
        return new String(new char[count]).replace("\0", str);
    }

        public static boolean konfirmasiPembelian(Scanner scanner) {
            System.out.print("Apakah Anda yakin ingin melanjutkan pembelian? (ya/tidak): ");
            String input = scanner.nextLine();
            return input.equalsIgnoreCase("ya");
        }

    public static void tampilkanStrukPembelian(ArrayList<Mobil> pembelianMobilList) {
        String garis = repeat("=", 120); 
        System.out.println(garis);
        System.out.println("|                                                   STRUK PEMBELIAN                                                   |");
        System.out.println(garis);
        System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-6s | %-15s | %-10s |%n",
                "Nama Mobil", "Brand", "Jenis", "Harga", "Warna", "Tahun Produksi", "Negara");
        System.out.println(garis);

        for (Mobil mobil : pembelianMobilList) {
            System.out.printf("| %-20s | %-15s | %-15s | %-10.2f | %-6s | %-15d | %-10s |%n",
                    mobil.getNamaMobil(), mobil.getBrandMobil(), mobil.getJenisMobil(),
                    mobil.getHargaMobil(), mobil.getWarnaMobil(), mobil.getTahunProduksi(), mobil.getNegaraProduksi());
        }

        System.out.println(garis);

        double totalHarga = pembelianMobilList.stream().mapToDouble(Mobil::getHargaMobil).sum();
        System.out.printf("| %-66s | %-10.2f |%n", "Total Harga", totalHarga);

        System.out.println(garis);
    }

    public static void simpanKeDatabase(ArrayList<Mobil> pembelianMobilList, int customer_id, Connection connection) throws SQLException {
        for (Mobil mobil : pembelianMobilList) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO tb_datapembelianmobil (customer_id, nama_mobil, brand_mobil, jenis_mobil, harga_mobil, warna_mobil, tahun_produksi, negara_produksi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            )) {
                statement.setInt(1, customer_id);
                statement.setString(2, mobil.getNamaMobil());
                statement.setString(3, mobil.getBrandMobil());
                statement.setString(4, mobil.getJenisMobil());
                statement.setDouble(5, mobil.getHargaMobil());
                statement.setString(6, mobil.getWarnaMobil());
                statement.setInt(7, mobil.getTahunProduksi());
                statement.setString(8, mobil.getNegaraProduksi());

                statement.executeUpdate();
            }
        }
    }

    public static void hapusDariTabelMobil(ArrayList<Mobil> pembelianMobilList, Connection connection) throws SQLException {
        for (Mobil mobil : pembelianMobilList) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM tb_mobil WHERE nama_mobil = ?"
            )) {
                statement.setString(1, mobil.getNamaMobil());
                statement.executeUpdate();
            }
        }
    }

    public static void hapusDariPenyimpananMobilList(ArrayList<Mobil> pembelianMobilList, ArrayList<Mobil> penyimpananMobilList) {
        for (Mobil mobil : pembelianMobilList) {
            penyimpananMobilList.removeIf(m -> m.getIdMobil() == mobil.getIdMobil());
        }
    }
}

public class RiwayatPembelian {

    public static void lihatRiwayatPembelian(Connection connection, int customer_id) {
        try {
            // Query SQL untuk mengambil data riwayat pembelian berdasarkan customer_id
            String query = "SELECT * FROM tb_datapembelianmobil WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customer_id);

            // Eksekusi query
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\nRiwayat Pembelian");

            // Periksa apakah ada riwayat pembelian
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Tidak ada riwayat pembelian.");
            } else {
                int pembelianIndex = 1;
                // Tampilkan data riwayat pembelian
                while (resultSet.next()) {
                    System.out.println("Pembelian ke-" + pembelianIndex + ":");
                    System.out.println("Nama Mobil: " + resultSet.getString("nama_mobil"));
                    System.out.println("Brand Mobil: " + resultSet.getString("brand_mobil"));
                    System.out.println("Jenis Mobil: " + resultSet.getString("jenis_mobil"));
                    System.out.println("Harga Mobil: " + resultSet.getDouble("harga_mobil"));
                    System.out.println("Warna Mobil: " + resultSet.getString("warna_mobil"));
                    System.out.println("Tahun Produksi: " + resultSet.getInt("tahun_produksi"));
                    System.out.println("Negara Produksi: " + resultSet.getString("negara_produksi"));
                    System.out.println("-----------------------------------------");
                    pembelianIndex++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saat mengambil riwayat pembelian: " + e.getMessage());
            }
        }
    }
}
