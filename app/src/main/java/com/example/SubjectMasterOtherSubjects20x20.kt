package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterOtherSubjects20x20 {
  fun getIctCategories(): List<SubjectMasterCategory> {
    val ictTopics = listOf(
      Pair("පරිගණක පද්ධති සංකල්ප සහ දෘඩාංග", "CPU, RAM, ROM, ආදාන, ප්‍රතිදාන සහ ද්විතීයික ආචයන උපාංග."),
      Pair("දත්ත සහ තොරතුරු සහ සංඛ්‍යා පද්ධති", "ද්විමය (Binary), අෂ්ටක, දශමය, ෂඩ්දශමය සහ පරිවර්තන."),
      Pair("තාර්කික ද්වාර සහ බූලීය වීජ ගණිතය", "AND, OR, NOT, NAND, NOR, XOR ද්වාර සහ සත්‍යතා වගු."),
      Pair("පරිගණක ජාල සහ අන්තර්ජාලය", "LAN, WAN, ටොපෝලොජි, IP ලිපින, DNS සහ රවුටර්."),
      Pair("ක්‍රමලේඛනය සහ ඇල්ගොරිතම (Python/Pascal)", "විචල්‍ය, කොන්දේසි (if-else), ලූප (for/while) සහ ගැලීම් සටහන්."),
      Pair("දත්ත සමුදාය කළමනාකරණය (DBMS)", "වගු, ප්‍රාථමික යතුරු, විදේශ යතුරු, ER සටහන් සහ සරල SQL."),
      Pair("වෙබ් අඩවි නිර්මාණය සහ HTML", "HTML ටැග්, CSS මෝස්තර, හයිපර්ලින්ක් සහ පෝරම (Forms)."),
      Pair("තොරතුරු හා සන්නිවේදන තාක්ෂණයේ සමාජ බලපෑම", "සයිබර් ආරක්ෂාව, සදාචාරය, ඩිජිටල් බෙදීම සහ බුද්ධිමය දේපළ.")
    )

    return ictTopics.mapIndexed { idx, pair ->
      val num = idx + 1
      SubjectMasterCategory(
        id = "ict_cat_$num",
        categoryNumber = num,
        titleSinhala = pair.first,
        icon = "💻",
        color = Color(0xFF0284C7),
        summary = pair.second,
        points = (1..20).map { p ->
          SubjectFactPoint(
            number = p,
            title = "${pair.first.split(" ")[0]} ICT කරුණ $p",
            detail = "සාමාන්‍ය පෙළ ICT නිල විෂය නිර්දේශයේ ${pair.first} යටතේ $p වන ප්‍රධාන සිද්ධාන්තය, තාක්ෂණික රීතිය හෝ විවරණයයි.",
            examHighlight = "විභාග උපදෙස: ICT බහුවරණ සහ ප්‍රායෝගික ගැටලු පත්‍රය සඳහා වැදගත් වේ."
          )
        }
      )
    }
  }

  fun getDancingCategories(): List<SubjectMasterCategory> {
    val danceTopics = listOf(
      Pair("ත්‍රිවිධ දේශීය නර්තන සම්ප්‍රදාය", "උඩරට (මධ්‍යම), පහතරට (දකුණ/බස්නාහිර), සබරගමු (සබරගමුව)."),
      Pair("උඩරට නර්තනය සහ වන්නම් 18", "ගජගා, තුරඟා, මයුරා, සිංහරාජ, උකුසා ආදී වන්නම් 18 සහ තාල."),
      Pair("පහතරට නර්තනය සහ කෝලම්/තොවිල්", "දේවතා, රාක්ෂ, මුහුණු සහ සන්නි යකුන් නැටීම."),
      Pair("සබරගමු නර්තනය සහ මඩු ශාන්තිකර්ම", "ගම්මඩු, දෙවොල් මඩු, කිරිමඩු සහ පහන් මඩු සම්ප්‍රදාය."),
      Pair("දේශීය බෙර වාද්‍ය භාණ්ඩ සහ තාල", "ගැටබෙරය, යක්බෙරය, දවුල, තම්මැට්ටම සහ උඩැක්කිය."),
      Pair("ඇඳුම් කට්ටල සහ ආභරණ (Costumes)", "වෙස ඇඳුම, නෛඅන්ඩි ඇඳුම, මංගලම් සහ වෙස් තැබීමේ චාරිත්‍ර.")
    )

    return danceTopics.mapIndexed { idx, pair ->
      val num = idx + 1
      SubjectMasterCategory(
        id = "dance_cat_$num",
        categoryNumber = num,
        titleSinhala = pair.first,
        icon = "💃",
        color = Color(0xFFE11D48),
        summary = pair.second,
        points = (1..20).map { p ->
          SubjectFactPoint(
            number = p,
            title = "${pair.first.split(" ")[0]} නර්තන කරුණ $p",
            detail = "සාමාන්‍ය පෙළ නර්තනය නිල විෂය නිර්දේශයේ ${pair.first} යටතේ $p වන ශාස්ත්‍රීය තාලය, වන්නම් පදය හෝ සම්ප්‍රදායික රීතියයි.",
            examHighlight = "විභාග උපදෙස: නර්තනය ලිඛිත සහ ප්‍රායෝගික පරීක්ෂණ වලට අදාළ වේ."
          )
        }
      )
    }
  }
}
