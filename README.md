## 🗄️ Хранение данных

Приложение использует **SharedPreferences** для сохранения учетных данных пользователя. 

### Особенности реализации:
- **Формат хранения**: XML-файл
- **Расположение**:    
  `/data/data/com.example.myapplication7/shared_prefs/our_shared_pref.xml`

- **Пример содержимого**:
  ```xml
  <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
  <map>
    <string name="Username">user123</string>
    <string name="Password">pass123</string>
  </map>