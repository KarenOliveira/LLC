// $ANTLR 2.7.6 (2005-12-22): "gramatica.g" -> "MeuParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MeuParser extends antlr.LLkParser       implements MeuParserTokenTypes
 {

	java.util.Map<String, String> mapaVar;
	Programa p;

	public void setPrograma(String name) {
		p = new Programa(name);
	}

	public Programa getPrograma() {
		return p;
	}

protected MeuParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected MeuParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenStream lexer) {
  this(lexer,1);
}

public MeuParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void prog() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			
						mapaVar = new java.util.HashMap<String, String>();
				
			match(LITERAL_programa);
			declara();
			bloco();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void declara() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_declare);
			{
			switch ( LA(1)) {
			case LITERAL_dec:
			{
				match(LITERAL_dec);
				break;
			}
			case LITERAL_num:
			{
				match(LITERAL_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(T_Id);
			
						mapaVar.put(LT(0).getText(), LT(-1).getText());p.addCommand(new CmdDeclara(LT(0).getText(),LT(-1).getText()));
					
			{
			_loop6:
			do {
				if ((LA(1)==T_virg)) {
					match(T_virg);
					{
					switch ( LA(1)) {
					case LITERAL_dec:
					{
						match(LITERAL_dec);
						break;
					}
					case LITERAL_num:
					{
						match(LITERAL_num);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(T_Id);
					
								mapaVar.put(LT(0).getText(), LT(-1).getText());p.addCommand(new CmdDeclara(LT(0).getText(),LT(-1).getText()));
							
				}
				else {
					break _loop6;
				}
				
			} while (true);
			}
			match(T_pontof);
			
						p.setVariaveis(mapaVar);
						System.out.println("Variable list assembled...");
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void bloco() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt9=0;
			_loop9:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt9>=1 ) { break _loop9; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt9++;
			} while (true);
			}
			match(LITERAL_fimprog);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_leia:
			{
				cmdLeia();
				match(T_pontof);
				break;
			}
			case LITERAL_escreva:
			{
				cmdEscr();
				match(T_pontof);
				break;
			}
			case T_Id:
			{
				cmdAttr();
				match(T_pontof);
				break;
			}
			case LITERAL_se:
			case LITERAL_end:
			{
				cmdIf();
				break;
			}
			case LITERAL_enquanto:
			{
				cmdWhile();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void cmdLeia() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_leia);
			match(T_ap);
			match(T_Id);
			
						if (mapaVar.get(LT(0).getText()) == null) {
							throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
						}
						p.addCommand(new CmdLeitura(LT(0).getText(),mapaVar.get(LT(0).getText())));
					
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdEscr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_escreva);
			match(T_ap);
			{
			switch ( LA(1)) {
			case T_texto:
			{
				match(T_texto);
				break;
			}
			case T_Id:
			{
				match(T_Id);
				
							if (mapaVar.get(LT(0).getText()) == null) {
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
							}
						
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
						p.addCommand(new CmdEscrita(LT(0).getText()));
					
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdAttr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_Id);
			
						if (mapaVar.get(LT(0).getText()) == null) {
							throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
				            	}
					
			match(T_attr);
			expr();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdIf() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_se:
			{
				match(LITERAL_se);
				
							p.addCommand(new CmdIf(LT(1).getText(),LT(2).getText(),LT(3).getText()));
						
				{
				expr();
				match(T_rel);
				expr();
				}
				match(LITERAL_entao);
				{
				int _cnt18=0;
				_loop18:
				do {
					if ((_tokenSet_1.member(LA(1)))) {
						cmd();
					}
					else {
						if ( _cnt18>=1 ) { break _loop18; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt18++;
				} while (true);
				}
				{
				if ((LA(1)==LITERAL_senao)) {
					match(LITERAL_senao);
					
								p.addCommand(new CmdSenao());
							
					{
					int _cnt21=0;
					_loop21:
					do {
						if ((_tokenSet_1.member(LA(1)))) {
							cmd();
						}
						else {
							if ( _cnt21>=1 ) { break _loop21; } else {throw new NoViableAltException(LT(1), getFilename());}
						}
						
						_cnt21++;
					} while (true);
					}
				}
				else if ((_tokenSet_2.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			case LITERAL_end:
			{
				end();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void cmdWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_enquanto);
			
						p.addCommand(new CmdWhile(LT(1).getText(),LT(2).getText(),LT(3).getText()));
					
			{
			expr();
			match(T_rel);
			expr();
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop27:
			do {
				if ((LA(1)==T_soma||LA(1)==T_subt)) {
					{
					switch ( LA(1)) {
					case T_soma:
					{
						match(T_soma);
						break;
					}
					case T_subt:
					{
						match(T_subt);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					termo();
				}
				else {
					break _loop27;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void end() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_end);
			
						p.addCommand(new CmdEnd());
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void termo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			fator();
			{
			_loop31:
			do {
				if ((LA(1)==T_mult||LA(1)==T_divi)) {
					{
					switch ( LA(1)) {
					case T_mult:
					{
						match(T_mult);
						break;
					}
					case T_divi:
					{
						match(T_divi);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					fator();
				}
				else {
					break _loop31;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void fator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				
							if (mapaVar.get(LT(0).getText()) == null) {
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
							}
						
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			case T_dec:
			{
				match(T_dec);
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr();
				match(T_fp);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"programa\"",
		"\"declare\"",
		"\"dec\"",
		"\"num\"",
		"T_Id",
		"T_virg",
		"T_pontof",
		"\"fimprog\"",
		"\"leia\"",
		"T_ap",
		"T_fp",
		"\"escreva\"",
		"T_texto",
		"T_attr",
		"\"se\"",
		"T_rel",
		"\"entao\"",
		"\"senao\"",
		"\"enquanto\"",
		"T_soma",
		"T_subt",
		"T_mult",
		"T_divi",
		"T_num",
		"T_dec",
		"\"end\"",
		"T_comm",
		"T_ac",
		"T_fc",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 541364480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 543463680L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 1024L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 545053952L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 570219776L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 670883072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	
	}
