-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2021 at 01:22 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `puskesmas`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int(6) NOT NULL,
  `id_transaksi` char(3) NOT NULL,
  `kode_obat` char(10) NOT NULL,
  `harga` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail`, `id_transaksi`, `kode_obat`, `harga`) VALUES
(32, '4', 'ko4', '50000'),
(33, 'kp5', 'ko1', '5000'),
(34, 'kp5', 'ko5', '2000'),
(36, 'kp5', 'ko4', '50000'),
(37, 'kp5', 'ko6', '80000'),
(39, 'kp6', 'ko2', '15000'),
(40, 'kp6', 'ko3', '700'),
(41, 'kp7', 'ko6', '80000'),
(42, 'kp3', 'ko2', '15000'),
(43, 'kp3', 'ko1', '5000');

--
-- Triggers `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `edit_harga` AFTER UPDATE ON `detail_transaksi` FOR EACH ROW UPDATE transaksi SET biaya = biaya-OLD.harga+NEW.harga WHERE Id_Transaksi = NEW.Id_transaksi
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `hapus_harga` AFTER DELETE ON `detail_transaksi` FOR EACH ROW UPDATE transaksi SET biaya = biaya-OLD.harga WHERE Id_Transaksi = OLD.Id_transaksi
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `harga` AFTER INSERT ON `detail_transaksi` FOR EACH ROW UPDATE transaksi SET biaya = biaya+NEW.harga WHERE Id_Transaksi = NEW.Id_transaksi
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `Id_Dokter` char(3) NOT NULL,
  `Nama_Dokter` varchar(30) NOT NULL,
  `Nama_Inisial` varchar(15) NOT NULL,
  `Gender` enum('L','P') NOT NULL,
  `Spesialis` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `gambar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`Id_Dokter`, `Nama_Dokter`, `Nama_Inisial`, `Gender`, `Spesialis`, `alamat`, `no_telp`, `gambar`) VALUES
('1', 'Fahril', 'Fah', 'L', 'Penyakit Kulit', 'Sumberbaru', 'w09876', 'eberhard-grossgasteiger-cgEbku0EbOg-unsplash.jpg'),
('2', 'Denny', 'Dn', 'L', 'UMUM', 'Sumberbaru', '08765', '4908068.jpg'),
('3', 'Denny', 'Dn', 'L', 'UMUM', 'Sumberbaru', '08765', '4908068.jpg'),
('4', 'Hairul', 'Irul', 'L', 'Penyakit Dalam', 'Situbondo', '0987', 'io.png'),
('5', 'Puji Astuti', 'Puji', 'P', 'Penyakit Dalam', 'Kelapa Gading', '28765', 'th (2).jpg'),
('6', 'Feri', 'F', 'L', 'UMUM', 'Wonorejo', '097', 'add_contact_23062.png');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_diagnosis`
--

CREATE TABLE `hasil_diagnosis` (
  `Kode_Diagnosis` char(10) NOT NULL,
  `Kode_Pasien` int(16) NOT NULL,
  `Hasil_Diagnosis` varchar(50) NOT NULL,
  `tanggal_pemeriksaan` date NOT NULL,
  `Id_Dokter` char(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hasil_diagnosis`
--

INSERT INTO `hasil_diagnosis` (`Kode_Diagnosis`, `Kode_Pasien`, `Hasil_Diagnosis`, `tanggal_pemeriksaan`, `Id_Dokter`) VALUES
('1', 123, 'sakit pusing', '2021-07-07', '1'),
('12', 1, 'sakit perut', '2021-07-06', '1'),
('2', 1, 'politik', '2021-07-05', '1'),
('3', 123, 'sakit pusing', '2021-07-07', '1'),
('4', 1, 'lambung kronis', '2021-07-04', '1'),
('5', 123, 'perut', '2021-07-08', '1'),
('6', 12345, 'Lambung Kronis', '2021-07-04', '1');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_diagnosis2`
--

CREATE TABLE `hasil_diagnosis2` (
  `Nomer` int(10) NOT NULL,
  `Kode_Diagnosis` char(10) NOT NULL,
  `Kode_Pasien` int(16) NOT NULL,
  `nama_pasien` varchar(15) NOT NULL,
  `hasil_pemeriksaan` varchar(20) NOT NULL,
  `tanggal_pemeriksaan` date NOT NULL,
  `Nama_Dokter` varchar(15) NOT NULL,
  `Id_Resep` char(10) NOT NULL,
  `Nama_Obat` text NOT NULL,
  `jenis_obat` enum('Kapsul','Sirup') NOT NULL,
  `jumlah` int(3) NOT NULL,
  `pemakaian` enum('3x1/hari','2x1/hari','1x1/hari') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hasil_diagnosis2`
--

INSERT INTO `hasil_diagnosis2` (`Nomer`, `Kode_Diagnosis`, `Kode_Pasien`, `nama_pasien`, `hasil_pemeriksaan`, `tanggal_pemeriksaan`, `Nama_Dokter`, `Id_Resep`, `Nama_Obat`, `jenis_obat`, `jumlah`, `pemakaian`) VALUES
(1, 'DG-01', 123, 'Denny', 'sakit', '2021-07-14', 'Kondisi', '1', 'mag', 'Kapsul', 2, '3x1/hari'),
(2, 'DG-01', 123, 'Denny', 'Sakit Mikir', '2021-07-05', 'konfoi', '2', 'paramex', 'Kapsul', 3, '3x1/hari'),
(3, 'DG-01', 123, 'Denny', 'sakit', '2021-07-06', 'Yusril', '1', 'panadol', 'Kapsul', 2, '2x1/hari');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `Kode_Jadwal` char(3) NOT NULL,
  `Id_Petugas` int(16) NOT NULL,
  `Tanggal_Tugas` date NOT NULL,
  `Shift_Pagi` time NOT NULL,
  `Shift_PagiEnd` time NOT NULL,
  `Shift_Siang` time NOT NULL,
  `Shift_SiangEnd` time NOT NULL,
  `Shift_Malam` time NOT NULL,
  `Shift_MalamEnd` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`Kode_Jadwal`, `Id_Petugas`, `Tanggal_Tugas`, `Shift_Pagi`, `Shift_PagiEnd`, `Shift_Siang`, `Shift_SiangEnd`, `Shift_Malam`, `Shift_MalamEnd`) VALUES
('12', 2, '2021-07-13', '11:23:34', '00:00:00', '11:23:34', '00:00:00', '11:23:34', '00:00:00'),
('13', 1, '2021-07-04', '16:35:00', '17:35:00', '18:35:00', '20:35:00', '21:35:00', '22:35:00'),
('14', 1, '2021-07-04', '09:36:00', '09:36:00', '09:36:00', '09:36:00', '09:36:00', '09:36:00'),
('2', 1, '2021-07-06', '08:34:00', '00:00:00', '12:34:00', '00:00:00', '16:34:00', '00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `User_Name` int(16) NOT NULL,
  `Password` char(10) NOT NULL,
  `Hak_Akses` enum('Dokter','Petugas') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`User_Name`, `Password`, `Hak_Akses`) VALUES
(1210, '1210', 'Petugas'),
(1214, '1214', 'Petugas'),
(1219, '1219', 'Petugas'),
(1717, '1717', 'Dokter'),
(121212, '121212', 'Petugas'),
(131313, '131313', 'Dokter');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `Kode_Obat` char(10) NOT NULL,
  `Nama_Obat` varchar(100) NOT NULL,
  `kuantitas` int(2) NOT NULL,
  `satuan` enum('lembar','botol(20ml)','botol(10ml)') NOT NULL,
  `harga` int(15) NOT NULL,
  `tgl_kadaluarsa` date NOT NULL,
  `tgl_inputdata` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`Kode_Obat`, `Nama_Obat`, `kuantitas`, `satuan`, `harga`, `tgl_kadaluarsa`, `tgl_inputdata`) VALUES
('1', 'we', 1, 'lembar', 9000, '2021-07-07', '2021-07-22'),
('2', 'we', 1, 'lembar', 9000, '2021-07-22', '2021-07-05'),
('ko1', 'Paramex', 1, 'botol(20ml)', 5000, '2021-07-04', '2021-07-01'),
('ko2', 'Mag', 1, 'botol(20ml)', 15000, '2021-07-31', '2021-07-01'),
('ko3', 'Konidin', 1, 'lembar', 700, '2021-07-24', '2021-07-14'),
('ko4', 'TBC', 2, 'botol(10ml)', 50000, '2021-07-31', '2021-07-01'),
('ko5', 'OBH', 2, 'lembar', 2000, '2021-07-30', '2021-07-28'),
('ko6', 'Griseofulvin', 3, 'botol(10ml)', 80000, '2021-07-22', '2021-07-04'),
('ko7', 'Konidin', 1, 'botol(20ml)', 15000, '2021-07-04', '2021-07-01');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `Kode_Pasien` int(16) NOT NULL,
  `Nama_Lengkap` varchar(30) NOT NULL,
  `Nama_Inisial` varchar(15) NOT NULL,
  `Gender` enum('L','P') NOT NULL,
  `Tanggal_Lahir` date NOT NULL,
  `Alamat` text NOT NULL,
  `Keluhan` text NOT NULL,
  `Poli_Tujuan` enum('Poli Umum','Poli Gigi','Poli Gizi','Poli KIA') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`Kode_Pasien`, `Nama_Lengkap`, `Nama_Inisial`, `Gender`, `Tanggal_Lahir`, `Alamat`, `Keluhan`, `Poli_Tujuan`) VALUES
(1, 'Fendi Kurniawan', 'Endi', 'L', '2021-07-15', 'Sumbersari', 'Sakit Perut ', 'Poli Umum'),
(12, 'FIka Rahwawati', 'Ika', 'P', '2021-07-07', 'Sumberkolak', 'Pusing bagian belakang', 'Poli Umum'),
(123, 'Deri', 'De', 'L', '2021-07-04', 'Arjasa', 'Pusing', 'Poli Umum'),
(1234, 'Zaskia Sungkari', 'Kia', 'P', '2003-07-15', 'Jl. Ahmad Tamrin Blok D', 'Sakit Gigi', 'Poli Gigi'),
(12345, 'Ferdinan Paleka', 'Eka', 'L', '1997-07-07', 'Bogor Jabar', 'Susah Makan', 'Poli KIA'),
(12346, 'Sri Rahayu', 'Rahayu', 'P', '2014-07-06', 'Kapongan Situbondo', 'Batuk dan Pilek', 'Poli Umum');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `Id_Petugas` int(16) NOT NULL,
  `Nama_Petugas` varchar(30) NOT NULL,
  `Nama_Inisial` varchar(15) NOT NULL,
  `Gender` enum('L','P') NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `No_Hp` int(15) NOT NULL,
  `gambar` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`Id_Petugas`, `Nama_Petugas`, `Nama_Inisial`, `Gender`, `alamat`, `No_Hp`, `gambar`) VALUES
(1, 'yusril', 'df', 'P', 'fd', 889, 'poster.png'),
(2, 'yusri5l', 'dfh', 'L', 'fd', 8895, 'Group 21.png'),
(3, 'y', 'dfh', 'L', 'fd', 8895, '4908068.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `resep_obat`
--

CREATE TABLE `resep_obat` (
  `Id_Resep` int(10) NOT NULL,
  `Kode_Diagnosa` char(10) NOT NULL,
  `Kode_Obat` char(10) NOT NULL,
  `jenis_obat` enum('Kapsul','Sirup') NOT NULL,
  `jumlah` int(3) NOT NULL,
  `pemakaian` enum('3x1/hari','2x1/hari','1x1/hari') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `resep_obat`
--

INSERT INTO `resep_obat` (`Id_Resep`, `Kode_Diagnosa`, `Kode_Obat`, `jenis_obat`, `jumlah`, `pemakaian`) VALUES
(7, '5', '2', 'Kapsul', 8, '3x1/hari'),
(8, '5', '2', 'Sirup', 1, '1x1/hari'),
(9, '6', 'ko5', 'Kapsul', 5, '2x1/hari'),
(10, '6', 'ko2', 'Sirup', 1, '1x1/hari');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `Id_Transaksi` char(3) NOT NULL,
  `Id_Pasien` int(16) NOT NULL,
  `Tanggal_Transaksi` date NOT NULL,
  `Id_Petugas` int(16) NOT NULL,
  `biaya` int(7) NOT NULL,
  `tunai` int(7) NOT NULL,
  `kembalian` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`Id_Transaksi`, `Id_Pasien`, `Tanggal_Transaksi`, `Id_Petugas`, `biaya`, `tunai`, `kembalian`) VALUES
('4', 123, '2021-07-04', 1, 50000, 100000, 50000),
('kp3', 12345, '2021-07-04', 1, 20000, 100000, 80000),
('kp5', 1234, '2021-07-04', 1, 137000, 60000, -77000),
('kp6', 12345, '2021-07-04', 1, 15700, 100000, 84300),
('kp7', 12, '2021-07-18', 1, 80000, 100000, 20000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `kode_obat` (`kode_obat`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`Id_Dokter`);

--
-- Indexes for table `hasil_diagnosis`
--
ALTER TABLE `hasil_diagnosis`
  ADD PRIMARY KEY (`Kode_Diagnosis`),
  ADD KEY `Kode_Pasien` (`Kode_Pasien`),
  ADD KEY `Id_Dokter` (`Id_Dokter`);

--
-- Indexes for table `hasil_diagnosis2`
--
ALTER TABLE `hasil_diagnosis2`
  ADD PRIMARY KEY (`Nomer`),
  ADD KEY `Kode_Pasien` (`Kode_Pasien`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`Kode_Jadwal`),
  ADD KEY `Id_Petugas` (`Id_Petugas`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`User_Name`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`Kode_Obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`Kode_Pasien`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`Id_Petugas`);

--
-- Indexes for table `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD PRIMARY KEY (`Id_Resep`),
  ADD KEY `Kode_Diagnosa` (`Kode_Diagnosa`),
  ADD KEY `Obat` (`Kode_Obat`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`Id_Transaksi`),
  ADD KEY `Id_Pasien` (`Id_Pasien`),
  ADD KEY `Id_Petugas` (`Id_Petugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `hasil_diagnosis2`
--
ALTER TABLE `hasil_diagnosis2`
  MODIFY `Nomer` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `resep_obat`
--
ALTER TABLE `resep_obat`
  MODIFY `Id_Resep` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`Id_Transaksi`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`kode_obat`) REFERENCES `obat` (`Kode_Obat`);

--
-- Constraints for table `hasil_diagnosis`
--
ALTER TABLE `hasil_diagnosis`
  ADD CONSTRAINT `hasil_diagnosis_ibfk_1` FOREIGN KEY (`Kode_Pasien`) REFERENCES `pasien` (`Kode_Pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hasil_diagnosis_ibfk_2` FOREIGN KEY (`Id_Dokter`) REFERENCES `dokter` (`Id_Dokter`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hasil_diagnosis2`
--
ALTER TABLE `hasil_diagnosis2`
  ADD CONSTRAINT `hasil_diagnosis2_ibfk_1` FOREIGN KEY (`Kode_Pasien`) REFERENCES `pasien` (`Kode_Pasien`);

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`Id_Petugas`) REFERENCES `petugas` (`Id_Petugas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD CONSTRAINT `resep_obat_ibfk_1` FOREIGN KEY (`Kode_Diagnosa`) REFERENCES `hasil_diagnosis` (`Kode_Diagnosis`),
  ADD CONSTRAINT `resep_obat_ibfk_2` FOREIGN KEY (`Kode_Obat`) REFERENCES `obat` (`Kode_Obat`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`Id_Pasien`) REFERENCES `pasien` (`Kode_Pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`Id_Petugas`) REFERENCES `petugas` (`Id_Petugas`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
