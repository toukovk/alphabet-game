package com.toukovainiokaila.alphabet;

import android.util.Log;

public class EntryManager {
	public AlphabetEntry getEntryForKey(char c) {
		Log.d(AlphabetGameActivity.LOG_TAG, "getEntryFor " + c + " ("
				+ ((int) c) + ")");
		c = Character.toUpperCase(c);
		switch (c) {
		case 0:
			return null;
		case 'Ä':
			return EntryEnum.A_UML;
		case 'Å':
			return EntryEnum.A_O;
		case 'Ö':
			return EntryEnum.O_UML;
		default:
			try {
				return EntryEnum.valueOf(Character.toString(c));
			} catch (Exception e) {
				return null;
			}
		}
	}

	public interface AlphabetEntry {
		public int getSoundId();

		public int getImageId();

		public char getCharacter();
	}

	private enum EntryEnum implements AlphabetEntry {
		A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A_O, A_UML, O_UML;

		public int getSoundId() {
			switch (this) {
			case B:
				return com.toukovainiokaila.alphabet.R.raw.b;
			case A_O:
				return com.toukovainiokaila.alphabet.R.raw.a_o;
			case A_UML:
				return com.toukovainiokaila.alphabet.R.raw.a_uml;
			case C:
				return com.toukovainiokaila.alphabet.R.raw.c;
			case D:
				return com.toukovainiokaila.alphabet.R.raw.d;
			case E:
				return com.toukovainiokaila.alphabet.R.raw.e;
			case F:
				return com.toukovainiokaila.alphabet.R.raw.f;
			case G:
				return com.toukovainiokaila.alphabet.R.raw.g;
			case H:
				return com.toukovainiokaila.alphabet.R.raw.h;
			case I:
				return com.toukovainiokaila.alphabet.R.raw.i;
			case J:
				return com.toukovainiokaila.alphabet.R.raw.j;
			case K:
				return com.toukovainiokaila.alphabet.R.raw.k;
			case L:
				return com.toukovainiokaila.alphabet.R.raw.l;
			case M:
				return com.toukovainiokaila.alphabet.R.raw.m;
			case N:
				return com.toukovainiokaila.alphabet.R.raw.n;
			case O:
				return com.toukovainiokaila.alphabet.R.raw.o;
			case O_UML:
				return com.toukovainiokaila.alphabet.R.raw.o_uml;
			case P:
				return com.toukovainiokaila.alphabet.R.raw.p;
			case Q:
				return com.toukovainiokaila.alphabet.R.raw.q;
			case R:
				return com.toukovainiokaila.alphabet.R.raw.r;
			case S:
				return com.toukovainiokaila.alphabet.R.raw.s;
			case T:
				return com.toukovainiokaila.alphabet.R.raw.t;
			case U:
				return com.toukovainiokaila.alphabet.R.raw.u;
			case V:
				return com.toukovainiokaila.alphabet.R.raw.v;
			case W:
				return com.toukovainiokaila.alphabet.R.raw.w;
			case X:
				return com.toukovainiokaila.alphabet.R.raw.x;
			case Y:
				return com.toukovainiokaila.alphabet.R.raw.y;
			case Z:
				return com.toukovainiokaila.alphabet.R.raw.z;
			case A:
				return com.toukovainiokaila.alphabet.R.raw.a;
			default:
				return com.toukovainiokaila.alphabet.R.raw.a;
			}

		}

		@Override
		public int getImageId() {
			switch (this) {
			case B:
				return com.toukovainiokaila.alphabet.R.drawable.b;
			case A_O:
				return com.toukovainiokaila.alphabet.R.drawable.a_o;
			case A_UML:
				return com.toukovainiokaila.alphabet.R.drawable.a_uml;
			case C:
				return com.toukovainiokaila.alphabet.R.drawable.c;
			case D:
				return com.toukovainiokaila.alphabet.R.drawable.d;
			case E:
				return com.toukovainiokaila.alphabet.R.drawable.e;
			case F:
				return com.toukovainiokaila.alphabet.R.drawable.f;
			case G:
				return com.toukovainiokaila.alphabet.R.drawable.g;
			case H:
				return com.toukovainiokaila.alphabet.R.drawable.h;
			case I:
				return com.toukovainiokaila.alphabet.R.drawable.i;
			case J:
				return com.toukovainiokaila.alphabet.R.drawable.j;
			case K:
				return com.toukovainiokaila.alphabet.R.drawable.k;
			case L:
				return com.toukovainiokaila.alphabet.R.drawable.l;
			case M:
				return com.toukovainiokaila.alphabet.R.drawable.m;
			case N:
				return com.toukovainiokaila.alphabet.R.drawable.n;
			case O:
				return com.toukovainiokaila.alphabet.R.drawable.o;
			case O_UML:
				return com.toukovainiokaila.alphabet.R.drawable.o_uml;
			case P:
				return com.toukovainiokaila.alphabet.R.drawable.p;
			case Q:
				return com.toukovainiokaila.alphabet.R.drawable.q;
			case R:
				return com.toukovainiokaila.alphabet.R.drawable.r;
			case S:
				return com.toukovainiokaila.alphabet.R.drawable.s;
			case T:
				return com.toukovainiokaila.alphabet.R.drawable.t;
			case U:
				return com.toukovainiokaila.alphabet.R.drawable.u;
			case V:
				return com.toukovainiokaila.alphabet.R.drawable.v;
			case W:
				return com.toukovainiokaila.alphabet.R.drawable.w;
			case X:
				return com.toukovainiokaila.alphabet.R.drawable.x;
			case Y:
				return com.toukovainiokaila.alphabet.R.drawable.y;
			case Z:
				return com.toukovainiokaila.alphabet.R.drawable.z;
			case A:
				return com.toukovainiokaila.alphabet.R.drawable.a;
			default:
				return com.toukovainiokaila.alphabet.R.raw.a;
			}
		}

		@Override
		public char getCharacter() {
			switch (this) {
			case A_O:
				return 'å';
			case A_UML:
				return 'ä';
			case O_UML:
				return 'ö';
			default:
				return Character.toLowerCase(name().charAt(0));
			}
		}
	}
}
