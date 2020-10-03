package p12;
//: c12:AvailableCharSets.java
// Displays Charsets and aliases
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.charset.*;
import java.util.*;
import com.bruceeckel.simpletest.*;

public class AvailableCharSets {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    Map charSets = Charset.availableCharsets();
    Iterator it = charSets.keySet().iterator();
    while(it.hasNext()) {
      String csName = (String)it.next();
      System.out.print(csName);
      Iterator aliases = ((Charset)charSets.get(csName))
        .aliases().iterator();
      if(aliases.hasNext())
        System.out.print(": ");
      while(aliases.hasNext()) {
        System.out.print(aliases.next());
        if(aliases.hasNext())
          System.out.print(", ");
      }
      System.out.println();
    }
    monitor.expect(new String[] {
      "Big5: csBig5",
      "Big5-HKSCS: big5-hkscs, Big5_HKSCS, big5hkscs",
      "EUC-CN",
      "EUC-JP: eucjis, x-eucjp, csEUCPkdFmtjapanese, " +
      "eucjp, Extended_UNIX_Code_Packed_Format_for" +
      "_Japanese, x-euc-jp, euc_jp",
      "euc-jp-linux: euc_jp_linux",
      "EUC-KR: ksc5601, 5601, ksc5601_1987, ksc_5601, " +
      "ksc5601-1987, euc_kr, ks_c_5601-1987, " +
      "euckr, csEUCKR",
      "EUC-TW: cns11643, euc_tw, euctw",
      "GB18030: gb18030-2000",
      "GBK: GBK",
      "ISCII91: iscii, ST_SEV_358-88, iso-ir-153, " +
      "csISO153GOST1976874",
      "ISO-2022-CN-CNS: ISO2022CN_CNS",
      "ISO-2022-CN-GB: ISO2022CN_GB",
      "ISO-2022-KR: ISO2022KR, csISO2022KR",
      "ISO-8859-1: iso-ir-100, 8859_1, ISO_8859-1, " +
      "ISO8859_1, 819, csISOLatin1, IBM-819, " +
      "ISO_8859-1:1987, latin1, cp819, ISO8859-1, " +
      "IBM819, ISO_8859_1, l1",
      "ISO-8859-13",
      "ISO-8859-15: 8859_15, csISOlatin9, IBM923, cp923," +
      " 923, L9, IBM-923, ISO8859-15, LATIN9, " +
      "ISO_8859-15, LATIN0, csISOlatin0, " +
      "ISO8859_15_FDIS, ISO-8859-15",
      "ISO-8859-2", "ISO-8859-3", "ISO-8859-4",
      "ISO-8859-5", "ISO-8859-6", "ISO-8859-7",
      "ISO-8859-8", "ISO-8859-9", 
      "JIS0201: X0201, JIS_X0201, csHalfWidthKatakana",
      "JIS0208: JIS_C6626-1983, csISO87JISX0208, x0208, " +
      "JIS_X0208-1983, iso-ir-87",
      "JIS0212: jis_x0212-1990, x0212, iso-ir-159, " +
      "csISO159JISC02121990",
      "Johab: ms1361, ksc5601_1992, ksc5601-1992",
      "KOI8-R",
      "Shift_JIS: shift-jis, x-sjis, ms_kanji, " +
      "shift_jis, csShiftJIS, sjis, pck",
      "TIS-620",
      "US-ASCII: IBM367, ISO646-US, ANSI_X3.4-1986, " +
      "cp367, ASCII, iso_646.irv:1983, 646, us, iso-ir-6,"+
      " csASCII, ANSI_X3.4-1968, ISO_646.irv:1991",
      "UTF-16: UTF_16",
      "UTF-16BE: X-UTF-16BE, UTF_16BE, ISO-10646-UCS-2",
      "UTF-16LE: UTF_16LE, X-UTF-16LE",
      "UTF-8: UTF8", "windows-1250", "windows-1251",
      "windows-1252: cp1252",
      "windows-1253", "windows-1254", "windows-1255",
      "windows-1256", "windows-1257", "windows-1258",
      "windows-936: ms936, ms_936",
      "windows-949: ms_949, ms949", "windows-950: ms950",
    });
  }
} ///:~