Feature: Subscription

  Scenario Outline: Show validate message when input with invalid data for email
    Given Testmaster page is showed
     When The user input in email textbox with "<email>"
     Then The message "* Email không đúng định dạng" with red border will be showed

  Examples:
      | email           |
      |                 |
      | abc             |
      | abc@gmail       |
      | abc  @gmail.com |

  Scenario: Show error message when user input with existed email
    Given Testmaster page is showed
     When The user input in email textbox with "khanh.tx@live.com"
     Then The message "E-mail khanh.tx@live.com đã được sử dụng, bạn hãy chọn một E-mail khác" will be showed

  Scenario: Popup is closed and focus on Email field when user click Đồng ý button
    Given Testmaster page is showed
     When The user input in email textbox with "khanh.tx@live.com" and click Đồng ý button in pop up
     Then Popup is closed, focus on Email field and clear data in Email field

  Scenario: Show information screen when user input with valid and not existed email
      Given Testmaster page is showed
       When The user input in email textbox with "abcd4321"
       Then information screen will be showed with title: "Để phục vụ bạn được tốt hơn, bạn vui lòng cung cấp thêm các thông tin bên dưới.", Giới tính: "Không xác định", Loại tin muốn nhận: "Nhận tất cả các loại tin"

# Background: User must to input valid email
#       Given The user input valid email "abcd4321@gmail.com"
#     Scenario: Show error messahe when user input with blank data for Họ và tên field
#       Given Information pop up is showed
#        When The user input Ho va ten field with blank data
#        Then The message "* Bạn cần phải nhập dữ liệu" with red color and red border and yellow background
#
#    Scenario: Popup is closed when user click Escape
#      Given Information pop up is showed
#       When The user click Escape on screen
#       Then Popup is closed and focus on Email field
#
#    Scenario: Show message when user input correct infomation
#      Given Information pop up is showed
#       When The user input correct infomation with Họ và tên: "ABC"
#       Then The message "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký" is showed