# Monefy Exploratory Testing Charts

**Device:** iPhone 15 Pro  
**OS:** iOS 18.4.1

---

### Priority 1
**Given to charts with core critical flow features of the app due to main app purpose and business logic.**  
**Risk impact:** If charts are inaccurate or records stored incorrectly, user might lose trust and abandon the app.

---

### Priority 2
**Given to charts with major flow feature related to business logic, security risks, data flow and data monitoring**  
**Risk impact:** Inaccurate data handling or security data protection can result in financial mismanagement or data loss, damaging user's trust and raising potential data privacy concerns.

---

### Priority 3
**Given to charts with medium feature flow related to accessibility, usability and data reflection**  
**Risk impact:** Poor usability or accessibility can frustrate users, reducing consideration of the app for a long term usage, especially for new or less tech-savvy users.

---

## Priority 1

> **Explore:** Add income action  
**With:** Add income feature on main screen  
**To discover:** Correct data reflection on monitoring chart

**Summary:**
- User can add income to any category
- User can see changed balance on main monitoring chart

---

> **Explore:** Add expense action  
**With:** Add expense feature on main screen  
**To discover:** Expense records are stored in categories and shown on main monitoring chart

**Summary:**
- User can add expense and to add it to selected category
- User can see changed balance on main monitoring chart
- User can see changed expense percentage due to other expenses

---

## Priority 2

> **Explore:** All actions with categories  
**With:** Categories menu  
**To discover:** Records stored and shown on monitoring chart correctly per category

**Summary:**
- User can add category when adding new expense/income
- User can add new category with Categories menu
- User can edit category's name/icon
- User can disable category
- User can merge selected categories data
- User can delete category

**Insight:**
- As a user, would intuitively expect to see stored expense/income data when open certain category in Categories menu;
- When adding expense or deposit, would like to see suggested Categories with recent activity

---

> **Explore:** Add currency  
**With:** Settings menu and Currencies menu  
**To discover:** Main and additional currency operations

**Summary:**
- User can have main currency and see all data on monitoring chart related to it
- User can change main currency
- Monitoring chart shows correct data due to currency settings
- User can set exchange rate for additional currencies

**Insight:**  
User could not figure out how the main currency was selected by default as device's location and iTunes setting is set to Germany, but main currency was set to Ukrainian Hryvnia.

---

> **Explore:** Monthly budget setup  
**With:** Budget mode in Settings menu  
**To discover:** User sees expenses and income on monitoring chart due to set budget

**Summary:**
- User can see set budget on main monitoring chart in main currency
- User can see budget increases/decreases due to added income/expense data

---

> **Explore:** Passcode setup  
**With:** Passcode option in Settings menu; FaceID check, valid/invalid numeric passcode check  
**To discover:** Numeric and FaceID passcode features

**Summary:**
- User can see FaceID requested on opening the app
- User can see numeric passcode requested if discard FaceID check
- User can see numeric passcode requested on opening the app due to passcode setting

**Insight:**  
Security issue found: postponed passcode was not requested due to setting to require password after 1 minute when using the app, neither numeric, nor FaceID.

---

> **Explore:** Data backup export/import  
**With:** Data export option in Settings menu  
**To discover:** Backup export/import feature

**Summary:**
- User can create data backup
- User can import data backup
- User can see confirmation pop-up when creating a backup
- User can see all created backups to select from on import
- User can see warning notification about replacing data from the chosen backup

---

> **Explore:** Cross-account transactions  
**With:** Transfer feature across cash and payment card accounts  
**To discover:** Data on monitoring chart shown due to performed transfers between accounts

**Summary:**
- User has 2 default accounts: cash and payment card
- User can add/edit/remove accounts
- User can set different data to each of accounts
- User can transfer funds among accounts
- User can see corresponding data on main monitoring chart

---

## Priority 3

> **Explore:** New installed app experience  
**With:** User actions following the app guidance  
**To discover:** First user impression

**Summary:**
- User sees same language in the app as on his device
- User sees clear guidance how to proceed using app
- User can go back to previous step from any starting stage
- User can start using app without free trial
- User sees valid data on main screen: current month, selected account type, current balance and monitoring statistics, suggested categories.

---

> **Explore:** Data filtering by day/month/year  
**With:** Filter data menu per day/month/year/interval/all  
**To discover:** Data shown on monitoring chart due to selected setting

**Summary:**
- User can filter all data per day/month/year/selected interval/all or selected date

**Insight:**  
Usability issue found: when unselect Month and passing to main screen and back to filter menu - Day filter is selected. When deselecting the Day filter and passing to main screen and back - no filters are selected.

---

> **Explore:** App theme switch  
**With:** Settings menu Dark theme mode  
**To discover:** User interface and accessibility after switch to Dark theme

**Summary:**
- User can switch to dark theme
- User can see alert to reload app to activate new theme mode
- User can switch to white theme

---

> **Explore:** Records search and reflection  
**With:** Main search panel and balance menu  
**To discover:** Data shown correctly in a search result with valid correspondence to category

**Summary:**
- User can search for records using keywords
- User can see requested records in search results with mentioned categories
- User can pass to a category from search results of selected record

**Insight:**
Found issue: text of expense/income option in search result is not aligned with a text of belonging category