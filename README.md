# salimToggleButton
## You can use this library for custom toggle that i said that Salim

[![](https://jitpack.io/v/miladsalimiiii/salimToggleButton.svg)](https://jitpack.io/#miladsalimiiii/salimToggleButton)

### Preview

![20210609_164034](https://user-images.githubusercontent.com/31917346/123479424-272fca00-d616-11eb-89db-e50b420d2f52.jpg)


![20210609_163731](https://user-images.githubusercontent.com/31917346/123479476-3e6eb780-d616-11eb-88cb-c1f2dc3da7ec.gif)

![20210609_164103](https://user-images.githubusercontent.com/31917346/123479452-357de600-d616-11eb-8fd1-6eafbdde3577.jpg)

### Dependency

### Step 1
Add the JitPack repository to your build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
        
```

### Step 2
Add the dependency on module build.gradle:
```
	dependencies {
	         implementation 'com.github.miladsalimiiii:salimToggleButton:Tag'
	}
``` 

### Quickstart

```
        <com.milad.salimtogglebutton.ui.SalimToggleButton
            android:id="@+id/salimToggleButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginStart="24dp"
            android:layout_marginTop="16dp"
            android:layout_marginEnd="24dp"
            app:buttonBackground="@drawable/drawable_all_buttonbackground"
            app:firstTextOfButton="1"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:marginButton="2dp"
            app:numberOfButton="THREE"
            app:paddingButton="8dp"
            app:rootBackground="@drawable/drawable_all_togglebuttonbackground"
            app:secondTextOfButton="2"
            app:selectedButton="THREE"
            app:selectedTextColor="@color/purple_200"
            app:thirdTextOfButton="3"
            app:unSelectedTextColor="@color/black" />
```

# Pay attention that in this version this library work for layouts that use databindig.

Happy Coding . . .
