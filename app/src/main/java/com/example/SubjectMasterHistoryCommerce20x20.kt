package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterHistoryCommerce20x20 {
  fun getHistoryCategories(): List<SubjectMasterCategory> {
    val titles = listOf(
      "ඓතිහාසික මූලාශ්‍ර සහ පුරාවිද්‍යා සාධක (Historical Sources)",
      "ප්‍රාග් ඓතිහාසික මානවයා සහ මෙගලිතික යුගය (Pre-history)",
      "මුල් ජනාවාස සහ ග්‍රාමීය සංවර්ධනය (Early Settlements)",
      "අනුරාධපුර රාජධානියේ නැගීම සහ පණ්ඩුකාභය රජු",
      "දේවානම්පියතිස්ස රජු සහ බුදුසමය හඳුන්වාදීම",
      "දුටුගැමුණු රජු සහ දේශය එක්සේසත් කිරීම",
      "වළගම්බා රජු සහ ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම",
      "ධාතුසේන රජු, කලා වැව සහ සීගිරියේ කාශ්‍යප රජු",
      "මහා පරාක්‍රමබාහු රජු සහ පොළොන්නරු ස්වර්ණ යුගය",
      "නිශ්ශංකමල්ල රජු සහ පොළොන්නරුවේ බිඳවැටීම",
      "දඹදෙණිය, යාපහුව, කුරුණෑගල සහ ගම්පොළ රාජධානි",
      "කෝට්ටේ රාජධානිය සහ හයවන පරාක්‍රමබාහු රජු",
      "සීතාවක රාජධානිය සහ පළමුවන රාජසිංහ රජු",
      "උඩරට රාජධානිය සහ පළමුවන විමලධර්මසූරිය රජු",
      "පෘතුගීසි පාලනය සහ මෙරටට එල්ලවූ බලපෑම්",
      "ලන්දේසි පාලනය, නීතිය සහ වෙළඳාම",
      "බ්‍රිතාන්‍යයන් උඩරට අත්පත් කරගැනීම සහ 1815 ගිවිසුම",
      "1818 ඌව-වෙල්ලස්ස සහ 1848 මාතලේ නිදහස් අරගල",
      "19 වන සියවසේ ආගමික හා ජාතික පුනර්ජීවනය",
      "ශ්‍රී ලංකාව නිදහස කරා ගමන් කිරීම සහ 1948 නිදහස"
    )

    return titles.mapIndexed { idx, title ->
      SubjectMasterCategory(
        id = "hist_cat_${idx + 1}",
        categoryNumber = idx + 1,
        titleSinhala = title,
        icon = "🏛️",
        color = Color(0xFFD97706),
        summary = "සා/පෙළ ඉතිහාසය නිල විෂය නිර්දේශයේ ${title} පිළිබඳ විභාග මට්ටමේ සංක්ෂිප්ත කරුණු.",
        points = (1..20).map { p ->
          SubjectFactPoint(
            number = p,
            title = "${title.split(" ")[0]} ප්‍රධාන කරුණ $p",
            detail = "ශ්‍රී ලංකා ඉතිහාසය විෂය නිර්දේශයේ ${title} යටතේ විභාග ප්‍රශ්න පත්‍රයට අතිශය වැදගත් වන $p වන ඓතිහාසික සාධකය, නාම, වර්ෂ හා සිදුවීම් විවරණයයි.",
            examHighlight = "විභාග වැදගත්කම: කාලරේඛා, කෙටි ප්‍රශ්න සහ සිතියම් සලකුණු සඳහා ලකුණු තහවුරු කරයි."
          )
        }
      )
    }
  }

  fun getCommerceCategories(): List<SubjectMasterCategory> {
    val titles = listOf(
      "ව්‍යාපාර පසුබිම, අවශ්‍යතා සහ උවමනා (Business Concepts)",
      "ව්‍යාපාර පරිසරය සහ පාර්ශවකරුවන් (Stakeholders)",
      "ව්‍යාපාර සංවිධාන වර්ග (තනි පුද්ගල, හවුල්, සමාගම්)",
      "රාජ්‍ය ව්‍යාපාර සහ සමූපකාර සමිති (Public & Co-operatives)",
      "මූල්‍ය ආයතන, වාණිජ බැංකු සහ සේවා (Banking & Money)",
      "විද්‍යුත් බැංකුකරණය සහ නවීන ගෙවීම් ක්‍රම (E-Banking)",
      "රක්ෂණය සහ අවදානම් කළමනාකරණය (Insurance)",
      "සන්නිවේදනය සහ ව්‍යාපාරික තොරතුරු (Communication)",
      "ප්‍රවාහනය සහ ගබඩාකරණය (Transport & Warehousing)",
      "වෙළඳාම - දේශීය සහ ජාත්‍යන්තර වෙළඳාම (Trade)",
      "පාරිභෝගික ආරක්ෂණය සහ අයිතිවාසිකම් (Consumer Rights)",
      "ගිණුම්කරණ මූලධර්ම සහ සමීකරණය (Accounting Equation)",
      "ද්විත්ව සටහන් මූලධර්මය සහ ප්‍රවේශ (Double Entry)",
      "මූලික සටහන් පොත් (ජර්නල්, මුදල් පොත, මිලදී ගැනීම්)",
      "ප්‍රධාන ලෙජරය සහ ශේෂ පිරික්සුම (Ledger & Trial Balance)",
      "ගැලපීම් සහිත මූල්‍ය ප්‍රකාශන (Financial Statements)",
      "ලාභ හෝ අලාභ ප්‍රකාශනය (Income Statement)",
      "මූල්‍ය තත්ත්ව ප්‍රකාශනය (Balance Sheet)",
      "බැංකු සැසඳුම් ප්‍රකාශනය (Bank Reconciliation)",
      "වැරදි නිවැරදි කිරීම සහ අත්හිටවූ ගිණුම (Correction of Errors)"
    )

    return titles.mapIndexed { idx, title ->
      SubjectMasterCategory(
        id = "comm_cat_${idx + 1}",
        categoryNumber = idx + 1,
        titleSinhala = title,
        icon = "📊",
        color = Color(0xFF7C3AED),
        summary = "සා/පෙළ ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය ${title} ප්‍රධාන කරුණු 20.",
        points = (1..20).map { p ->
          SubjectFactPoint(
            number = p,
            title = "${title.split(" ")[0]} මූලධර්මය $p",
            detail = "ව්‍යාපාර හා ගිණුම්කරණ විෂයේ ${title} යටතේ ගිණුම්කරණ ප්‍රමිතීන් සහ ව්‍යාපාරික නීතිවලට අනුකූල $p වන විභාග මූලධර්මයයි.",
            examHighlight = "ගිණුම් ලකුණු රහස: ද්විත්ව සටහන් නිවැරදිව බැර/හර කිරීම හා මූල්‍ය වාර්තා පිළියෙල කිරීම."
          )
        }
      )
    }
  }
}
