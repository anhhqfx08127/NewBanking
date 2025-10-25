# 💡 Lab 2: Ứng dụng các Mẫu Thiết Kế (Design Patterns)

## 🧭 Giới thiệu
Trong **Lab 2**, sinh viên đã **nghiên cứu và áp dụng 8 mẫu thiết kế hướng đối tượng (OOP Design Patterns)** để xây dựng ứng dụng **AppBanking** bằng ngôn ngữ **Kotlin**.  
Mục tiêu của bài là thể hiện **khả năng tổ chức, mở rộng và tái sử dụng mã nguồn** trong mô hình ứng dụng ngân hàng.

---

## 🧩 Các mẫu thiết kế được áp dụng

### 🏭 Factory Method
- Tạo các loại tài khoản khác nhau (`DepositAccount`, `SalaryAccount`, ...) thông qua lớp `AccountFactory`.

### ⚙️ Strategy
- Xây dựng các **chiến lược tính phí giao dịch linh hoạt**, như:
  - `PercentFee`
  - `FixedFee`
  - `NoFee`

### 👀 Observer
- Theo dõi và gửi thông báo khi **số dư tài khoản thay đổi**.  
- Các lớp chính: `NotificationService`, `AccountObserver`.

### 🔒 Singleton
- Đảm bảo **`NotificationService` chỉ tồn tại duy nhất một thể hiện** trong toàn hệ thống.

### 🎨 Decorator
- Mở rộng hành vi giao dịch như:
  - Ghi log (`LoggingDecorator`)
  - Gửi thông báo (`NotifyDecorator`)
  - Đo thời gian thực thi (`TimingDecorator`)  
→ mà **không cần chỉnh sửa lớp gốc**.

### 🧱 Builder
- Hỗ trợ **tạo giao dịch từng bước** thông qua `TransactionBuilder`, giúp mã dễ đọc và dễ mở rộng.

### 🎭 State
- Quản lý **các trạng thái tài khoản** và hành vi tương ứng:
  - `Active`
  - `Frozen`
  - `Closed`

### 🔁 Iterator
- Cho phép **duyệt qua lịch sử giao dịch** của tài khoản một cách thống nhất,  
  không phụ thuộc vào cấu trúc dữ liệu bên trong.

---

## 🗂️ Cấu trúc project

```

src/
├── builder/
├── decorator/
├── factory/
├── iterator/
├── singletonobserver/
├── state/
└── strategy/

```

---