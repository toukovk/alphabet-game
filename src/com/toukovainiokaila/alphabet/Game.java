package com.toukovainiokaila.alphabet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.toukovainiokaila.alphabet.EntryManager.AlphabetEntry;

public class Game extends Activity {
	private TextView charView;
	private ImageView imageView;
	private EditText charInput;

	private char lastCharOnScreen = 0;

	private static final String CHAR_ON_SCREEN = "charOnScreen";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(AlphabetGameActivity.LOG_TAG, "Game onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		charView = (TextView) findViewById(R.id.char_view);
		imageView = (ImageView) findViewById(R.id.image_view);
		charInput = (EditText) findViewById(R.id.input_text);
		charInput.addTextChangedListener(new TextEditWatcher());

		// Initial content
		charView.setText(getResources().getString(R.string.press_a_key));

		showSoftKeyboard3();
	}

	// private void showSoftKeyboard() {
	// InputMethodManager im = (InputMethodManager)
	// getSystemService(Context.INPUT_METHOD_SERVICE);
	// // Following works on Android 2.2 portrait (doesn't seem to work w/3.1)
	// im.toggleSoftInput(InputMethodManager.SHOW_FORCED,
	// InputMethodManager.HIDE_NOT_ALWAYS);
	// }
	//
	// private void showSoftKeyboard2() {
	// InputMethodManager im = (InputMethodManager)
	// getSystemService(Context.INPUT_METHOD_SERVICE);
	// // Following: is shown after orientation changed
	// im.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	// }

	private void showSoftKeyboard3() {
		getWindow().setSoftInputMode(
				LayoutParams.SOFT_INPUT_ADJUST_RESIZE
						| LayoutParams.SOFT_INPUT_STATE_VISIBLE);
	}

	private char determineCharacter(int keyCode) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_A:
			return 'a';
		case KeyEvent.KEYCODE_B:
			return 'b';
		case KeyEvent.KEYCODE_C:
			return 'c';
		case KeyEvent.KEYCODE_D:
			return 'd';
		case KeyEvent.KEYCODE_E:
			return 'e';
		case KeyEvent.KEYCODE_F:
			return 'f';
		case KeyEvent.KEYCODE_G:
			return 'g';
		case KeyEvent.KEYCODE_H:
			return 'h';
		case KeyEvent.KEYCODE_I:
			return 'i';
		case KeyEvent.KEYCODE_J:
			return 'j';
		case KeyEvent.KEYCODE_K:
			return 'k';
		case KeyEvent.KEYCODE_L:
			return 'l';
		case KeyEvent.KEYCODE_M:
			return 'm';
		case KeyEvent.KEYCODE_N:
			return 'n';
		case KeyEvent.KEYCODE_O:
			return 'o';
		case KeyEvent.KEYCODE_P:
			return 'p';
		case KeyEvent.KEYCODE_Q:
			return 'q';
		case KeyEvent.KEYCODE_R:
			return 'r';
		case KeyEvent.KEYCODE_S:
			return 's';
		case KeyEvent.KEYCODE_T:
			return 't';
		case KeyEvent.KEYCODE_U:
			return 'u';
		case KeyEvent.KEYCODE_V:
			return 'v';
		case KeyEvent.KEYCODE_W:
			return 'w';
		case KeyEvent.KEYCODE_X:
			return 'x';
		case KeyEvent.KEYCODE_Y:
			return 'y';
		case KeyEvent.KEYCODE_Z:
			return 'z';

			// Emulator handles scandinavian keys as following
		case KeyEvent.KEYCODE_LEFT_BRACKET:
			return 'Œ';
		case KeyEvent.KEYCODE_SEMICOLON:
			return 'š';
		case KeyEvent.KEYCODE_APOSTROPHE:
			return 'Š';
		default:
			return 0;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.d(AlphabetGameActivity.LOG_TAG, "onKeyDown, keyCode " + keyCode);
		char c = determineCharacter(keyCode);
		if (handleChar(c, true)) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private boolean handleChar(char c, boolean firstTime) {
		if (c == 0) {
			return false;
		}
		AlphabetEntry entry = AlphabetGameActivity.entryManager
				.getEntryForKey(c);
		if (entry != null) {
			updateEntry(entry, firstTime);
			lastCharOnScreen = c;
			return true;
		}
		return false;
	}

	private void updateEntry(AlphabetEntry entry, boolean firstTime) {
		imageView.setImageResource(entry.getImageId());
		charView.setText(produceCharString(entry.getCharacter()));
		if (firstTime) {
			AlphabetGameActivity.soundPlayer.play(this, entry.getSoundId());
		}
	}

	private String produceCharString(char c) {
		return Character.toUpperCase(c) + " " + Character.toLowerCase(c);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putChar(CHAR_ON_SCREEN, lastCharOnScreen);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		char c = savedInstanceState.getChar(CHAR_ON_SCREEN, (char) 0);
		handleChar(c, false);
	}

	private void hideSoftKeyboard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(charInput.getWindowToken(), 0);
	}

	private class TextEditWatcher implements TextWatcher {
		@Override
		public void afterTextChanged(Editable s) {
			// Do nothing
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// Do nothing
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			Log.d(AlphabetGameActivity.LOG_TAG, "onTextChanged " + s);
			String text = charInput.getText().toString();
			if (text.length() > 0) {
				char c = text.charAt(0);
				handleChar(c, true);
				charInput.setText("");
			}
			hideSoftKeyboard();

		}
	}

}
