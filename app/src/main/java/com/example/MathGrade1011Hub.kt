package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlin.math.sqrt

/**
 * 100% ACCURATE O/L MATHEMATICS MASTER HUB FOR GRADES 10 & 11
 * Divided strictly by Grade 10 and Grade 11:
 * 1. ප්‍රමේය සහ ජ්‍යාමිතික සාධන (Theorems, Proofs & Constructions)
 * 2. වීජ ගණිතය, වර්ගජ ප්‍රස්ථාර & සමීකරණ (Algebra, Equations & Graphs)
 * 3. ත්‍රිකෝණමිතිය, මිනුම් & දිගංශය (Trigonometry, Mensuration & Bearing)
 * 4. මූල්‍ය ගණිතය, වාරික ණය & බදු (Financial Math, Loans & Taxes)
 * 5. සංඛ්‍යානය & සම්භාවිතා රුක් සටහන් (Statistics & Probability Tree Diagrams)
 * 6. Rapid-Fire O/L Maths Challenge (MCQs & Step-by-Step Solutions)
 */

enum class MathHubGradeFilter(val gradeStr: String, val title: String) {
  GRADE_10("10", "10 ශ්‍රේණිය (Grade 10)"),
  GRADE_11("11", "11 ශ්‍රේණිය (Grade 11)")
}

enum class MathHubModuleType(val title: String, val icon: String, val badgeColor: Color) {
  GEOMETRY("ජ්‍යාමිතිය & ප්‍රමේය", "📐", Color(0xFF0284C7)),
  ALGEBRA("වීජ ගණිතය & ප්‍රස්ථාර", "📈", Color(0xFFD97706)),
  TRIGONOMETRY("ත්‍රිකෝණමිතිය & මිනුම්", "📐", Color(0xFF059669)),
  FINANCIAL("මූල්‍ය ගණිතය & බදු", "💰", Color(0xFFE11D48)),
  STATISTICS("සංඛ්‍යානය & සම්භාවිතාව", "📊", Color(0xFF7C3AED)),
  CONSTRUCTIONS("ජ්‍යාමිතික නිර්මාණ", "📏", Color(0xFF0D9488)),
  LOGARITHMS("ලඝුගණක & අංකනය", "🧮", Color(0xFFD97706)),
  SETS_VENN("කුලක & වෙන් රූප", "⭕", Color(0xFF7C3AED)),
  PROGRESSIONS("ශ්‍රේඪි (AP & GP)", "🔢", Color(0xFFDB2777)),
  MATRICES_INEQ("න්‍යාස & අසමානතා", "🔲", Color(0xFF6366F1)),
  VELOCITY_GRAPHS("ප්‍රවේග-කාල ප්‍රස්ථාර", "🚗", Color(0xFF0284C7)),
  EXAM_TIPS("Marking & රහස්", "💡", Color(0xFFCA8A04)),
  RAPID_MCQ("Rapid-Fire O/L ගැටලු", "🎯", Color(0xFF2563EB))
}

// -------------------------------------------------------------
// 1. GEOMETRY THEOREM MODELS
// -------------------------------------------------------------
data class MathTheoremItem(
  val id: String,
  val grade: String,
  val title: String,
  val theoremNumber: String,
  val statement: String, // ප්‍රකාශය
  val givenData: String, // දත්තය
  val construction: String, // නිර්මාණය
  val proofSteps: List<String>, // සාධනය පියවර
  val converseStatement: String, // විලෝමය
  val examTip: String,
  val exampleProblem: String,
  val exampleSolution: String
)

// -------------------------------------------------------------
// 2. ALGEBRA & GRAPHS MODELS
// -------------------------------------------------------------
data class MathAlgebraItem(
  val id: String,
  val grade: String,
  val topic: String,
  val formula: String,
  val conceptSummary: String,
  val steps: List<String>,
  val sampleQuestion: String,
  val workedSolution: List<String>,
  val finalResult: String,
  val commonPitfalls: String
)

// -------------------------------------------------------------
// 3. TRIGONOMETRY & MENSURATION MODELS
// -------------------------------------------------------------
data class MathTrigItem(
  val id: String,
  val grade: String,
  val title: String,
  val subCategory: String, // "ත්‍රිකෝණමිතිය", "පරිමාව", "දිගංශය", "චාප දිග"
  val formula: String,
  val formulaExplanation: String,
  val questionText: String,
  val stepByStepWorking: List<String>,
  val finalAnswer: String,
  val practicalApplication: String
)

// -------------------------------------------------------------
// 4. FINANCIAL MATH MODELS
// -------------------------------------------------------------
data class MathFinancialItem(
  val id: String,
  val grade: String,
  val title: String,
  val category: String, // "හීනවන ශේෂ ණය", "වැල් පොලිය", "වරිපනම් බදු", "සුළු පොලිය"
  val formula: String,
  val rulesSummary: String,
  val problemText: String,
  val calculationSteps: List<String>,
  val answer: String,
  val examAdvice: String
)

// -------------------------------------------------------------
// 5. STATISTICS & PROBABILITY MODELS
// -------------------------------------------------------------
data class MathStatItem(
  val id: String,
  val grade: String,
  val title: String,
  val method: String,
  val formula: String,
  val keyPoints: List<String>,
  val workedExampleQuestion: String,
  val solutionSteps: List<String>,
  val finalValue: String
)

// -------------------------------------------------------------
// 6. RAPID-FIRE MCQ & SHORT PROBLEMS
// -------------------------------------------------------------
data class MathRapidProblem(
  val id: String,
  val grade: String,
  val unitName: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val stepByStepExplanation: String
)

// =============================================================
// REPOSITORY: 100% ACCURATE O/L SYLLABUS MATHEMATICS DATA
// =============================================================
object MathGrade1011SyllabusRepository {

  // 1. GEOMETRY THEOREMS (Grade 10 & 11)
  val geometryTheorems = listOf(
    // Grade 10 Theorems
    MathTheoremItem(
      id = "geo_10_01",
      grade = "10",
      title = "ත්‍රිකෝණයක කෝණවල ඓක්‍යය ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 01",
      statement = "ඕනෑම ත්‍රිකෝණයක අභ්‍යන්තර කෝණ තුනෙහි එකතුව 180° කි (සෘජුකෝණ 2කි).",
      givenData = "ABC යනු ත්‍රිකෝණයකි.",
      construction = "A හරහා BC පාදයට සමාන්තරව PQ සරල රේඛාව අඳින්න.",
      proofSteps = listOf(
        "PQ // BC බැවින් PÂB = A^BC (ඒකාන්තර කෝණ)",
        "QÂC = A^CB (ඒකාන්තර කෝණ)",
        "PQ සරල රේඛාවක් බැවින් PÂB + BÂC + QÂC = 180° (සරල රේඛාවක බද්ධ කෝණ)",
        "එබැවින් A^BC + BÂC + A^CB = 180° වේ."
      ),
      converseStatement = "බහුඅස්‍රයක අභ්‍යන්තර කෝණ එකතුව (2n - 4) සෘජුකෝණ වේ.",
      examTip = "ජ්‍යාමිතික සාධනයකදී සෑම පියවරකටම ඉදිරියෙන් හේතුව (වරහන් තුළ) ලිවීමෙන් සම්පූර්ණ ලකුණු ලැබේ.",
      exampleProblem = "ABC ත්‍රිකෝණයේ A^BC = 65° ද, A^CB = 45° ද නම්, BÂC කෝණයේ අගය සොයන්න.",
      exampleSolution = "BÂC = 180° - (65° + 45°) = 180° - 110° = 70°"
    ),
    MathTheoremItem(
      id = "geo_10_02",
      grade = "10",
      title = "ත්‍රිකෝණයක බාහිර කෝණය පිළිබඳ ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 02",
      statement = "ත්‍රිකෝණයක පාදයක් දික් කළ විට සෑදෙන බාහිර කෝණය, එහි අභ්‍යන්තර ප්‍රතිමුඛ කෝණ දෙකෙහි එකතුවට සමාන වේ.",
      givenData = "ABC ත්‍රිකෝණයේ BC පාදය D දක්වා දික් කර ඇත. A^CD යනු බාහිර කෝණයයි.",
      construction = "අවශ්‍ය නොවේ.",
      proofSteps = listOf(
        "A^CB + A^CD = 180° (සරල රේඛාවක බද්ධ කෝණ)",
        "BÂC + A^BC + A^CB = 180° (ත්‍රිකෝණයක අභ්‍යන්තර කෝණ ඓක්‍යය)",
        "එබැවින් A^CB + A^CD = BÂC + A^BC + A^CB",
        "දෙපසින්ම A^CB ඉවත් කළ විට: A^CD = BÂC + A^BC වේ."
      ),
      converseStatement = "බාහිර කෝණය අභ්‍යන්තර ප්‍රතිමුඛ එක් එක් කෝණයට වඩා විශාල වේ.",
      examTip = "සමද්වීපාද ත්‍රිකෝණ ගැටලු විසඳීමේදී මෙම බාහිර කෝණ ප්‍රමේයය අතිශයින් වැදගත් වේ.",
      exampleProblem = "ත්‍රිකෝණයේ අභ්‍යන්තර ප්‍රතිමුඛ කෝණ 50° සහ 70° නම්, බාහිර කෝණය කොපමණද?",
      exampleSolution = "බාහිර කෝණය = 50° + 70° = 120°"
    ),
    MathTheoremItem(
      id = "geo_10_03",
      grade = "10",
      title = "සමාන්තරාස්‍ර වල ප්‍රමේයයන් (ගුණාංග)",
      theoremNumber = "ප්‍රමේය 03",
      statement = "සමාන්තරාස්‍රයක: (i) සම්මුඛ පාද සමාන වේ. (ii) සම්මුඛ කෝණ සමාන වේ. (iii) විකර්ණ එකිනෙක සමච්ඡේදනය කරයි.",
      givenData = "ABCD යනු සමාන්තරාස්‍රයකි (AB // DC සහ AD // BC).",
      construction = "AC විකර්ණය යා කරන්න.",
      proofSteps = listOf(
        "ΔABC සහ ΔCDA සලකන්න:",
        "BÂC = A^CD (AB // DC බැවින් ඒකාන්තර කෝණ)",
        "B^CA = CÂD (AD // BC බැවින් ඒකාන්තර කෝණ)",
        "AC = AC (පොදු පාදය)",
        "එබැවින් ΔABC ≡ ΔCDA (කෝ.පා.කෝ)",
        "එමගින් AB = CD සහ BC = AD ද, A^BC = A^DC ද වේ.",
        "විකර්ණ අඳින විට සෑදෙන ප්‍රතිමුඛ ත්‍රිකෝණ අංගසාම්‍යයෙන් විකර්ණ සමච්ඡේදනය වන බව සාධනය වේ."
      ),
      converseStatement = "චතුරස්‍රයක සම්මුඛ පාද යුගල සමාන නම් හෝ සම්මුඛ කෝණ සමාන නම් හෝ විකර්ණ සමච්ඡේදනය වේ නම් එය සමාන්තරාස්‍රයකි.",
      examTip = "පාද යුගලක් සමාන මෙන්ම සමාන්තර වුවහොත් (AB = DC සහ AB // DC) එය සමාන්තරාස්‍රයක් වීමට ප්‍රමාණවත්ය.",
      exampleProblem = "සමාන්තරාස්‍රයක එක් කෝණයක් 110° කි. ඉතිරි කෝණ තුන සොයන්න.",
      exampleSolution = "සම්මුඛ කෝණය = 110°. මිත්‍ර කෝණ ඓක්‍යය 180° බැවින් යාබද කෝණ = 180° - 110° = 70°. ඉතිරි කෝණ: 70°, 110°, 70°."
    ),

    // Grade 11 Theorems (Circles & Tangents)
    MathTheoremItem(
      id = "geo_11_01",
      grade = "11",
      title = "වෘත්ත කේන්ද්‍රය සහ ජ්‍යාය පිළිබඳ ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 04 (වෘත්ත)",
      statement = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්බකය මඟින් එම ජ්‍යාය සමච්ඡේදනය කෙරේ.",
      givenData = "O කේන්ද්‍රය වූ වෘත්තයේ AB ජ්‍යායකි. OM ⊥ AB වේ.",
      construction = "OA සහ OB අරයන් යා කරන්න.",
      proofSteps = listOf(
        "ΔOMA සහ ΔOMB සෘජුකෝණී ත්‍රිකෝණ සලකන්න:",
        "O^MA = O^MB = 90° (දත්තය)",
        "OA = OB (එකම වෘත්තයේ අරයයන්)",
        "OM = OM (පොදු පාදය)",
        "එබැවින් ΔOMA ≡ ΔOMB (කර්ණ - පාදය අංගසාම්‍යය)",
        "එමගින් AM = MB වේ. (ජ්‍යාය සමච්ඡේදනය වේ)."
      ),
      converseStatement = "වෘත්තයක කේන්ද්‍රය හා ජ්‍යායක මධ්‍ය ලක්ෂ්‍යය යා කරන රේඛාව එම ජ්‍යායට ලම්බ වේ.",
      examTip = "පයිතගරස් ප්‍රමේයය (r² = d² + (L/2)²) ආශ්‍රයෙන් ජ්‍යායක දිග හෝ කේන්ද්‍රයේ සිට දුර සෙවීමට O/L ප්‍රශ්න පත්‍රයේ බහුලව පැමිණේ.",
      exampleProblem = "අරය 10 cm වූ වෘත්තයක කේන්ද්‍රයේ සිට 6 cm දුරින් පිහිටි ජ්‍යායේ දිග සොයන්න.",
      exampleSolution = "AM² = OA² - OM² = 10² - 6² = 100 - 36 = 64. AM = 8 cm. ජ්‍යායේ මුළු දිග AB = 2 × 8 = 16 cm."
    ),
    MathTheoremItem(
      id = "geo_11_02",
      grade = "11",
      title = "කේන්ද්‍රීය කෝණය හා පරිධියේ කෝණය ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 05 (වෘත්ත කෝණ)",
      statement = "වෘත්තයක චාපයක් මඟින් කේන්ද්‍රය හමුවේ ආපාතනය කරන කෝණය, එම චාපයෙන්ම පරිධියේ ඉතිරි කොටස මත ආපාතනය කරන කෝණය මෙන් දෙගුණයකි.",
      givenData = "O කේන්ද්‍රය වූ වෘත්තයේ AB චාපයෙන් කේන්ද්‍රය මත AÔB ද, පරිධිය මත A^PB ද සාදයි.",
      construction = "PO යා කර Q දක්වා දික් කරන්න.",
      proofSteps = listOf(
        "ΔOAP හි OA = OP (අරය) බැවින් OÂP = O^PA වේ.",
        "බාහිර කෝණය AÔQ = OÂP + O^PA = 2 × O^PA.",
        "එලෙසම ΔOBP හි බාහිර කෝණය BÔQ = 2 × O^PB.",
        "එකතු කළ විට: AÔQ + BÔQ = 2(O^PA + O^PB)",
        "එනම් AÔB = 2 × A^PB වේ."
      ),
      converseStatement = "එකම චාපය මත පිහිටි කෝණ සමාන වේ. අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (90°).",
      examTip = "අර්ධ වෘත්තයේ කෝණය 90° බව භාවිතා කර සෘජුකෝණී ත්‍රිකෝණ සාදා ගැටලු විසඳීම ප්‍රධාන විභාග උපායකි.",
      exampleProblem = "වෘත්ත පරිධියේ කෝණය 38° ක් නම්, එම චාපයෙන්ම කේන්ද්‍රය මත සාදන කෝණය සොයන්න.",
      exampleSolution = "කේන්ද්‍රීය කෝණය = 2 × 38° = 76°"
    ),
    MathTheoremItem(
      id = "geo_11_03",
      grade = "11",
      title = "චක්‍රීය චතුරස්‍ර ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 06 (චක්‍රීය චතුරස්‍ර)",
      statement = "චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණ එකිනෙකට අතිපූරක වේ (එකතුව 180° වේ). බාහිර කෝණය අභ්‍යන්තර ප්‍රතිමුඛ කෝණයට සමාන වේ.",
      givenData = "ABCD යනු වෘත්තය මත පිහිටි චතුරස්‍රයකි.",
      construction = "OB සහ OD අරයන් යා කරන්න.",
      proofSteps = listOf(
        "පරිධියේ B^CD මඟින් කේන්ද්‍රයේ ආපාතනය කරන සුළු කෝණය BÔD = 2 × B^CD.",
        "පරිධියේ BÂD මඟින් කේන්ද්‍රයේ ආපාතනය කරන පරාවර්ත කෝණය BÔD = 2 × BÂD.",
        "සුළු කෝණය + පරාවර්ත කෝණය = 360° (ලක්ෂ්‍යයක් වටා කෝණ)",
        "2 × B^CD + 2 × BÂD = 360°",
        "දෙපසම 2න් බෙදූ විට: BÂD + B^CD = 180° වේ."
      ),
      converseStatement = "චතුරස්‍රයක සම්මුඛ කෝණ එකතුව 180° නම් එහි ශීර්ෂ 4 වෘත්තයක් මත පිහිටයි (චක්‍රීය වේ).",
      examTip = "ජ්‍යාමිතික සාධනයකදී ලක්ෂ්‍ය 4ක් චක්‍රීය බව පෙන්වීමට සම්මුඛ කෝණ ඓක්‍යය 180° බව පෙන්වීම ප්‍රමාණවත්ය.",
      exampleProblem = "චක්‍රීය චතුරස්‍රයක එක් කෝණයක් (3x + 10)° ද, සම්මුඛ කෝණය (2x + 20)° ද නම් x හි අගය සොයන්න.",
      exampleSolution = "(3x + 10) + (2x + 20) = 180 ➔ 5x + 30 = 180 ➔ 5x = 150 ➔ x = 30°"
    ),
    MathTheoremItem(
      id = "geo_11_04",
      grade = "11",
      title = "වෘත්තයක ස්පර්ශක සහ ඒකාන්තර ඛණ්ඩ ප්‍රමේයය",
      theoremNumber = "ප්‍රමේය 07 (ස්පර්ශක)",
      statement = "වෘත්තයක ස්පර්ශ ලක්ෂ්‍යයේදී අඳින ලද ජ්‍යායක් හා ස්පර්ශකය අතර කෝණය, එම ජ්‍යාය මඟින් ඒකාන්තර වෘත්ත ඛණ්ඩයේ ආපාතනය කරන කෝණයට සමාන වේ.",
      givenData = "PQR යනු B ලක්ෂ්‍යයේදී වෘත්තයට ඇඳි ස්පර්ශකයකි. AB ජ්‍යායකි. C යනු ඒකාන්තර ඛණ්ඩයේ ලක්ෂ්‍යයකි.",
      construction = "BD විෂ්කම්භය ඇඳ AD යා කරන්න.",
      proofSteps = listOf(
        "BÂD = 90° (අර්ධ වෘත්තයේ කෝණය)",
        "එබැවින් A^DB + A^BD = 90°",
        "නමුත් D^BR = 90° (ස්පර්ශ ලක්ෂ්‍යයේ අරය ස්පර්ශකයට ලම්බ වේ)",
        "එබැවින් A^BR + A^BD = 90°",
        "එබැවින් A^BR = A^DB වේ.",
        "එකම චාපයේ කෝණ බැවින් A^DB = A^CB වේ.",
        "එබැවින් A^BR = A^CB (ඒකාන්තර ඛණ්ඩ ප්‍රමේයය)."
      ),
      converseStatement = "සරල රේඛාවක් හා ජ්‍යායක් අතර කෝණය ඒකාන්තර ඛණ්ඩයේ කෝණයට සමාන නම් එම රේඛාව ස්පර්ශකයකි.",
      examTip = "බාහිර ලක්ෂ්‍යයක සිට වෘත්තයකට ඇඳි ස්පර්ශක ඛණ්ඩ දෙක දිගින් සමාන වේ (PA = PB).",
      exampleProblem = "ස්පර්ශකය හා ජ්‍යාය අතර කෝණය 55° කි. ඒකාන්තර වෘත්ත ඛණ්ඩයේ කෝණය කොපමණද?",
      exampleSolution = "ඒකාන්තර ඛණ්ඩ ප්‍රමේයය අනුව කෝණය = 55°"
    )
  )

  // 2. ALGEBRA & QUADRATIC GRAPHS (Grade 10 & 11)
  val algebraItems = listOf(
    // Grade 10 Algebra
    MathAlgebraItem(
      id = "alg_10_01",
      grade = "10",
      topic = "වර්ග දෙකක අන්තරය හා ත්‍රිපද සාධක",
      formula = "a² - b² = (a - b)(a + b)  සහ  x² + (p+q)x + pq = (x+p)(x+q)",
      conceptSummary = "වීජීය ප්‍රකාශන සාධකවලට වෙන් කිරීමේදී පළමුව පොදු සාධක ඇත්නම් පිටතට ගත යුතුය. ඉන්පසු වර්ග දෙකක අන්තරය හෝ මැද පදය බෙදා වෙන් කිරීමේ ක්‍රමය යොදයි.",
      steps = listOf(
        "පළමුව පොදු පද ඇත්නම් වරහනෙන් පිටතට ගන්න.",
        "වර්ග දෙකක අන්තරයක් නම් වර්ගමූල සොයා (a-b)(a+b) ආකාරයට ලියන්න.",
        "ax² + bx + c සඳහා: ගුණිතය ac වන සහ එකතුව b වන සංඛ්‍යා දෙක (p, q) සොයා මැද පදය කඩන්න."
      ),
      sampleQuestion = "සාධක සොයන්න: (i) 4x² - 25  (ii) x² - 7x + 12",
      workedSolution = listOf(
        "(i) 4x² - 25 = (2x)² - (5)² = (2x - 5)(2x + 5)",
        "(ii) ගුණිතය = +12, එකතුව = -7. සංඛ්‍යා දෙක: -3 සහ -4",
        "x² - 3x - 4x + 12 = x(x - 3) - 4(x - 3) = (x - 3)(x - 4)"
      ),
      finalResult = "(2x - 5)(2x + 5) සහ (x - 3)(x - 4)",
      commonPitfalls = "ලකුණු වැරදීම: ගුණිතය ධන වී එකතුව ඍණ වන විට සාධක දෙකම ඍණ විය යුතුය (-3 × -4 = +12, -3 + -4 = -7)."
    ),
    MathAlgebraItem(
      id = "alg_10_02",
      grade = "10",
      topic = "සමගාමී සරල සමීකරණ විසඳීම",
      formula = "ax + by = m  සහ  cx + dy = n",
      conceptSummary = "විචල්‍යයන් දෙකක් අඩංගු සමීකරණ දෙකක් එකවර විසඳීම. සංගුණක සමාන කර එකතු කිරීමෙන් හෝ අඩු කිරීමෙන් එක් විචල්‍යයක් ඉවත් කරයි.",
      steps = listOf(
        "සමීකරණ දෙක (1) සහ (2) ලෙස නම් කරන්න.",
        "එක් විචල්‍යයක සංගුණක සමාන වන සේ ගුණ කරන්න.",
        "ලකුණු එක සමාන නම් අඩු කරන්න; ප්‍රතිවිරුද්ධ නම් එකතු කරන්න.",
        "ලැබෙන අගය එක් සමීකරණයකට ආදේශ කර අනෙක් විචල්‍යය සොයන්න."
      ),
      sampleQuestion = "විසඳන්න: 2x + 3y = 13  සහ  x - y = -1",
      workedSolution = listOf(
        "(2) වන සමීකරණය 3න් ගුණ කරන්න: 3x - 3y = -3  --- (3)",
        "(1) + (3): (2x + 3x) + (3y - 3y) = 13 + (-3)",
        "5x = 10 ➔ x = 2",
        "x = 2 අගය (2) ට ආදේශ කරන්න: 2 - y = -1 ➔ -y = -3 ➔ y = 3"
      ),
      finalResult = "x = 2, y = 3",
      commonPitfalls = "සමීකරණ අඩු කිරීමේදී වරහන් තුළ ලකුණු වෙනස් වීම අමතක වීම."
    ),

    // Grade 11 Algebra
    MathAlgebraItem(
      id = "alg_11_01",
      grade = "11",
      topic = "වර්ගජ සමීකරණ සූත්‍රය සහ වර්ග පූර්ණය",
      formula = "x = [-b ± √(b² - 4ac)] / (2a)",
      conceptSummary = "සාධක සෙවිය නොහැකි වර්ගජ සමීකරණ විසඳීමට වර්ගජ සූත්‍රය හෝ වර්ග පූර්ණ ක්‍රමය භාවිත කෙරේ. b² - 4ac යනු විවේචකයයි.",
      steps = listOf(
        "සමීකරණය ax² + bx + c = 0 සම්මත ආකාරයට ලියන්න.",
        "a, b, c අගයන් ලකුණු සහිතව නිවැරදිව හඳුනාගන්න.",
        "විවේචකය b² - 4ac හි අගය වෙනම ගණනය කරන්න.",
        "සූත්‍රයට ආදේශ කර ± ලකුණ අනුව විසඳුම් 2 ලබාගන්න."
      ),
      sampleQuestion = "විසඳන්න: 2x² + 5x - 3 = 0",
      workedSolution = listOf(
        "a = 2, b = 5, c = -3",
        "b² - 4ac = (5)² - 4(2)(-3) = 25 - (-24) = 25 + 24 = 49",
        "x = [-5 ± √49] / (2 × 2) = [-5 ± 7] / 4",
        "x₁ = (-5 + 7) / 4 = 2 / 4 = 1/2 (හෝ 0.5)",
        "x₂ = (-5 - 7) / 4 = -12 / 4 = -3"
      ),
      finalResult = "x = 1/2 හෝ x = -3",
      commonPitfalls = "c හි ඍණ ලකුණ නොසලකා හැරීම නිසා 4ac ඍණ වීමෙන් වැරදි පිළිතුරු ලැබීම. -4(2)(-3) = +24 වේ!"
    ),
    MathAlgebraItem(
      id = "alg_11_02",
      grade = "11",
      topic = "වර්ගජ ශ්‍රිත ප්‍රස්ථාර විවරණය (Quadratic Graphs)",
      formula = "y = a(x - h)² + k  හෝ  y = ax² + bx + c",
      conceptSummary = "වර්ගජ ශ්‍රිත ප්‍රස්ථාරයක් පරාවලයක් වේ. a > 0 නම් අවම හැරවුම් ලක්ෂ්‍යයක් ද, a < 0 නම් උපරිම හැරවුම් ලක්ෂ්‍යයක් ද ලැබේ.",
      steps = listOf(
        "හැරවුම් ලක්ෂ්‍යයේ ඛණ්ඩාංක = (h, k)",
        "සමමිතික අක්ෂයේ සමීකරණය: x = h",
        "ශ්‍රිතයේ උපරිම හෝ අවම අගය = k",
        "ශ්‍රිතය ධන වන පරාසය: ප්‍රස්ථාරය x-අක්ෂයට ඉහළින් ඇති x හි අගය පරාසය (y > 0)",
        "ශ්‍රිතය ඍණ වන පරාසය: ප්‍රස්ථාරය x-අක්ෂයට පහළින් ඇති x හි අගය පරාසය (y < 0)",
        "ශ්‍රිතයේ මූල: ප්‍රස්ථාරය x-අක්ෂය ඡේදනය කරන ලක්ෂ්‍යවල x ඛණ්ඩාංක (y = 0 විට)"
      ),
      sampleQuestion = "y = (x - 2)² - 9 ප්‍රස්ථාරයේ (i) හැරවුම් ලක්ෂ්‍යය (ii) සමමිතික අක්ෂය (iii) y < 0 වන x හි අගය පරාසය ලියන්න.",
      workedSolution = listOf(
        "(i) සමීකරණය y = (x - h)² + k සමඟ සැසඳූ විට h = 2, k = -9. හැරවුම් ලක්ෂ්‍යය = (2, -9) [අවම ලක්ෂ්‍යයකි].",
        "(ii) සමමිතික අක්ෂයේ සමීකරණය: x = 2",
        "(iii) x-අක්ෂය කපන ලක්ෂ්‍ය සඳහා y = 0: (x - 2)² = 9 ➔ x - 2 = ±3 ➔ x = 5 හෝ x = -1.",
        "පරාවලය අවම බැවින් x-අක්ෂයට පහළ කොටස (y < 0) පිහිටන්නේ -1 සහ 5 අතරයි."
      ),
      finalResult = "හැරවුම් ලක්ෂ්‍යය: (2, -9), සමමිතික අක්ෂය: x = 2, පරාසය: -1 < x < 5",
      commonPitfalls = "අක්ෂයේ සමීකරණය ලිවීමේදී '2' පමණක් නොලියා 'x = 2' ලෙස සමීකරණයක් ලෙසම ලිවිය යුතුය."
    )
  )

  // 3. TRIGONOMETRY, MENSURATION & BEARING (Grade 10 & 11)
  val trigAndMensurationItems = listOf(
    // Grade 10
    MathTrigItem(
      id = "trig_10_01",
      grade = "10",
      title = "ත්‍රිකෝණමිතික අනුපාත (sin, cos, tan)",
      subCategory = "ත්‍රිකෝණමිතිය",
      formula = "sin θ = සම්මුඛ / කර්ණය,  cos θ = බද්ධ / කර්ණය,  tan θ = සම්මුඛ / බද්ධ",
      formulaExplanation = "සෘජුකෝණී ත්‍රිකෝණයක සෘජුකෝණයට සම්මුඛ පාදය කර්ණය වේ. සලකන කෝණය θ ට ඉදිරියෙන් ඇති පාදය සම්මුඛ පාදය වන අතර ඊළඟට ඇති පාදය බද්ධ පාදයයි.",
      questionText = "සෘජුකෝණී ත්‍රිකෝණයක කර්ණය 10 cm ද, θ කෝණයට සම්මුඛ පාදය 6 cm ද වේ. (i) sin θ (ii) cos θ (iii) tan θ සොයන්න.",
      stepByStepWorking = listOf(
        "පයිතගරස් ප්‍රමේයයෙන් බද්ධ පාදය (b) සොයමු: b² = 10² - 6² = 100 - 36 = 64 ➔ b = 8 cm",
        "sin θ = සම්මුඛ / කර්ණය = 6 / 10 = 3/5 = 0.6",
        "cos θ = බද්ධ / කර්ණය = 8 / 10 = 4/5 = 0.8",
        "tan θ = සම්මුඛ / බද්ධ = 6 / 8 = 3/4 = 0.75"
      ),
      finalAnswer = "sin θ = 0.6, cos θ = 0.8, tan θ = 0.75",
      practicalApplication = "ගොඩනැගිලි හා කඳු වල උස ගණනය කිරීමට ඉංජිනේරු විද්‍යාවේදී යොදාගනී."
    ),
    MathTrigItem(
      id = "trig_10_02",
      grade = "10",
      title = "වෘත්ත අංශයක චාප දිග සහ වර්ගඵලය",
      subCategory = "මිනුම්",
      formula = "චාප දිග s = (θ/360) × 2πr,   වර්ගඵලය A = (θ/360) × πr²",
      formulaExplanation = "කේන්ද්‍ර කෝණය θ වන අරය r වූ වෘත්ත අංශයක සම්පූර්ණ වෘත්තයෙන් ගන්නා භාගය θ/360 වේ.",
      questionText = "අරය 14 cm වූ සහ කේන්ද්‍රික කෝණය 90° වූ වෘත්ත අංශයක (i) චාප දිග (ii) මුළු පරිමිතිය සොයන්න. (π = 22/7)",
      stepByStepWorking = listOf(
        "චාප දිග s = (90/360) × 2 × (22/7) × 14",
        "s = (1/4) × 2 × 22 × 2 = 22 cm",
        "මුළු පරිමිතිය = චාප දිග + අරයන් 2 = 22 + 14 + 14 = 50 cm"
      ),
      finalAnswer = "චාප දිග = 22 cm, මුළු පරිමිතිය = 50 cm",
      practicalApplication = "විදුලි පංකා තල, පයි ප්‍රස්ථාර කොටස් සහ වටරවුම් සැලසුම් කිරීමට යොදාගනී."
    ),

    // Grade 11
    MathTrigItem(
      id = "trig_11_01",
      grade = "11",
      title = "සිලින්ඩර, කේතු හා ගෝල වල පරිමාව සහ පෘෂ්ඨ වර්ගඵලය",
      subCategory = "පරිමාව",
      formula = "සිලින්ඩරය V = πr²h,   කේතුව V = (1/3)πr²h,   ගෝලය V = (4/3)πr³,  වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2πrh",
      formulaExplanation = "කේතුවක පරිමාව සමාන පාද අරයක් හා උසක් ඇති සිලින්ඩරයක පරිමාවෙන් හරියටම 1/3 කි.",
      questionText = "අරය 7 cm සහ උස 10 cm වූ ඝන සිලින්ඩරයක පරිමාව සහ වක්‍ර පෘෂ්ඨ වර්ගඵලය සොයන්න. (π = 22/7)",
      stepByStepWorking = listOf(
        "පරිමාව V = πr²h = (22/7) × 7 × 7 × 10 = 22 × 7 × 10 = 1540 cm³",
        "වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2πrh = 2 × (22/7) × 7 × 10 = 44 × 10 = 440 cm²"
      ),
      finalAnswer = "පරිමාව = 1540 cm³, වක්‍ර පෘෂ්ඨ වර්ගඵලය = 440 cm²",
      practicalApplication = "ජල ටැංකි, තෙල් බැරල් සහ බහාලුම්වල ධාරිතාව නිර්ණය කිරීමට."
    ),
    MathTrigItem(
      id = "trig_11_02",
      grade = "11",
      title = "ආරෝහණ / අවරෝහණ කෝණ සහ තුන්-ඉලක්කම් දිගංශය (Bearing)",
      subCategory = "දිගංශය",
      formula = "දිගංශය: උතුරු දිශාවේ සිට දක්ෂිණාවර්තව මනින කෝණය (000° සිට 360° දක්වා ඉලක්කම් 3කින් ලියයි)",
      formulaExplanation = "තිරස් මට්ටමේ සිට ඉහළ බලන විට ආරෝහණ කෝණය ද, තිරස් මට්ටමේ සිට පහළ බලන විට අවරෝහණ කෝණය ද සෑදේ. නිරීක්ෂකයා A සිට B දෙස බලන විට ආරෝහණ කෝණය = B සිට A දෙස බලන විට අවරෝහණ කෝණය.",
      questionText = "කුළුණක පාමුල සිට 20 m දුරින් පිහිටි පොළොව මත ලක්ෂ්‍යයක සිට කුළුණ මුදුනේ ආරෝහණ කෝණය 30° කි. කුළුණේ උස සොයන්න. (tan 30° = 0.577)",
      stepByStepWorking = listOf(
        "කුළුණේ උස h මීටර් යැයි ගනිමු. පාමුලට දුර = 20 m.",
        "tan 30° = සම්මුඛ පාදය / බද්ධ පාදය = h / 20",
        "h = 20 × tan 30° = 20 × 0.577 = 11.54 m"
      ),
      finalAnswer = "කුළුණේ උස = 11.54 m",
      practicalApplication = "නාවික ගමනාගමනය, ගුවන් නියමු දිශානතිය සහ මිනින්දෝරු මිනුම් කටයුතු."
    )
  )

  // 4. FINANCIAL MATHEMATICS (Grade 10 & 11)
  val financialMathItems = listOf(
    // Grade 10
    MathFinancialItem(
      id = "fin_10_01",
      grade = "10",
      title = "සුළු පොලිය සහ ප්‍රතිශත (ලාභ/අලාභ, වට්ටම්)",
      category = "සුළු පොලිය",
      formula = "I = (P × t × r) / 100   [I = මුළු පොලිය, P = මුදල, t = කාලය (අවුරුදු), r = වාර්ෂික පොලී අනුපාතිකය]",
      rulesSummary = "සුළු පොලියේදී එක් එක් වසර සඳහා ගෙවන පොලී මුදල නොවෙනස්ව පවතී.",
      problemText = "රු. 50,000 ක මුදලක් 12% වාර්ෂික සුළු පොලියකට අවුරුදු 3ක් තැන්පත් කළ විට ලැබෙන මුළු මුදල සොයන්න.",
      calculationSteps = listOf(
        "වසරක පොලිය = 50,000 × (12/100) = රු. 6,000",
        "අවුරුදු 3 සඳහා මුළු පොලිය I = 6,000 × 3 = රු. 18,000",
        "මුළු මුදල (Amount) = තැන්පත් මුදල + මුළු පොලිය = 50,000 + 18,000 = රු. 68,000"
      ),
      answer = "මුළු මුදල = රු. 68,000",
      examAdvice = "ප්‍රශ්නයේ අසන්නේ 'පොලිය' ද නැතහොත් 'මුළු මුදල' ද යන්න හොඳින් කියවා තහවුරු කරගන්න."
    ),

    // Grade 11
    MathFinancialItem(
      id = "fin_11_01",
      grade = "11",
      title = "හීනවන ශේෂ ක්‍රමයට පොලිය හා මාසික වාරිකය ගණනය",
      category = "හීනවන ශේෂ ණය",
      formula = "මාස ඒකක ගණන = [n(n + 1)] / 2,   මුළු පොලිය = ණය මුදල × (r/12) × [මාස ඒකක / n]",
      rulesSummary = "හීනවන ශේෂ ක්‍රමයේදී ණය මුදල වාරික ගෙවන විට අඩුවේ. පොලිය ගණනය කරන්නේ නොගෙවූ ශේෂය මතය. ඒ සඳහා මාස ඒකක ක්‍රමය යොදාගනී.",
      problemText = "රු. 24,000 ක ණය මුදලක් 12% වාර්ෂික පොලියකට සමාන මාසික වාරික 12 කින් ගෙවා නිම කිරීමට නම්, මාසික වාරිකය සොයන්න.",
      calculationSteps = listOf(
        "මාසයකදී ගෙවන ණය මුදල = 24,000 / 12 = රු. 2,000",
        "මාස ඒකක ගණන = [12 × (12 + 1)] / 2 = (12 × 13) / 2 = 78 ඒකක",
        "මාසයකට එක් ඒකකයක පොලිය = 2,000 × (12/100) × (1/12) = රු. 20",
        "මුළු පොලිය = 78 × 20 = රු. 1,560",
        "ගෙවිය යුතු මුළු මුදල = ණය මුදල + මුළු පොලිය = 24,000 + 1,560 = රු. 25,560",
        "මාසික වාරිකය = 25,560 / 12 = රු. 2,130"
      ),
      answer = "මාසික වාරිකය = රු. 2,130 (මුළු පොලිය = රු. 1,560)",
      examAdvice = "O/L දෙවන ප්‍රශ්න පත්‍රයේ B කොටසේ ප්‍රථම ප්‍රශ්නය බොහෝ විට මෙම හීනවන ශේෂ වාරික ණය ගැටලුවයි. පියවරෙන් පියවර ලිවීමෙන් ලකුණු 10ම ලබාගත හැක."
    ),
    MathFinancialItem(
      id = "fin_11_02",
      grade = "11",
      title = "වරිපනම් බදු සහ රේගු බදු (Taxes)",
      category = "වරිපනම් බදු",
      formula = "වාර්ෂික වරිපනම් බද්ද = වාර්ෂික තක්සේරු වටිනාකම × (බදු ප්‍රතිශතය / 100),   කාර්තුවකට බද්ද = වාර්ෂික බද්ද / 4",
      rulesSummary = "පළාත් පාලන ආයතන මඟින් නිවාස හා ගොඩනැගිලි මත අය කරන බද්ද වරිපනම් බද්දයි. වසරකට කාර්තු 4ක් ඇත.",
      problemText = "වාර්ෂික තක්සේරු වටිනාකම රු. 80,000 ක් වූ නිවසක් සඳහා 6% ක වාර්ෂික වරිපනම් බද්දක් අය කරයි නම්, එක් කාර්තුවකට ගෙවිය යුතු බද්ද සොයන්න.",
      calculationSteps = listOf(
        "වාර්ෂික වරිපනම් බද්ද = 80,000 × (6/100) = රු. 4,800",
        "කාර්තුවකට ගෙවිය යුතු බද්ද = 4,800 / 4 = රු. 1,200"
      ),
      answer = "කාර්තුවකට බද්ද = රු. 1,200",
      examAdvice = "කාර්තුවක් යනු මාස 3කි. වසරකට කාර්තු 4ක් ඇති බැවින් වාර්ෂික බද්ද 4න් බෙදිය යුතුය."
    )
  )

  // 5. STATISTICS & PROBABILITY (Grade 10 & 11)
  val statAndProbItems = listOf(
    // Grade 10
    MathStatItem(
      id = "stat_10_01",
      grade = "10",
      title = "සංඛ්‍යාත ව්‍යාප්තියක මධ්‍යන්‍යය සෙවීම",
      method = "සෘජු ක්‍රමය",
      formula = "මධ්‍යන්‍යය x̄ = Σfx / Σf",
      keyPoints = listOf(
        "f යනු සංඛ්‍යාතයයි",
        "x යනු අගය හෝ පන්ති ප්‍රාන්තරයේ මධ්‍ය අගයයි",
        "Σfx යනු fx ගුණිතයන්ගේ එකතුවයි",
        "Σf යනු මුළු සංඛ්‍යාතයයි"
      ),
      workedExampleQuestion = "ලකුණු (x): 5, 10, 15  සහ ශිෂ්‍ය සංඛ්‍යාව (f): 2, 5, 3 නම් මධ්‍යන්‍යය සොයන්න.",
      solutionSteps = listOf(
        "Σf = 2 + 5 + 3 = 10",
        "fx අගයන්: 5×2 = 10,  10×5 = 50,  15×3 = 45",
        "Σfx = 10 + 50 + 45 = 105",
        "මධ්‍යන්‍යය x̄ = 105 / 10 = 10.5"
      ),
      finalValue = "10.5"
    ),

    // Grade 11
    MathStatItem(
      id = "stat_11_01",
      grade = "11",
      title = "උපකල්පිත මධ්‍යන්‍ය ක්‍රමයෙන් මධ්‍යන්‍යය සෙවීම",
      method = "උපකල්පිත මධ්‍යන්‍ය ක්‍රමය (Assumed Mean)",
      formula = "මධ්‍යන්‍යය x̄ = A + (Σfd / Σf)",
      keyPoints = listOf(
        "A යනු උපකල්පිත මධ්‍යන්‍යයයි (සාමාන්‍යයෙන් මැද පන්තියේ මධ්‍ය අගය තෝරාගනී)",
        "d යනු අපගමනයයි: d = x - A",
        "fd යනු සංඛ්‍යාතය සහ අපගමනයේ ගුණිතයයි",
        "ගණනය කිරීම් සරල කර ගැනීමට මෙම ක්‍රමය අතිශයින් ප්‍රයෝජනවත්ය"
      ),
      workedExampleQuestion = "Σf = 50 ද, උපකල්පිත මධ්‍යන්‍යය A = 35 ද, Σfd = +150 ද නම් සත්‍ය මධ්‍යන්‍යය සොයන්න.",
      solutionSteps = listOf(
        "මධ්‍යන්‍යය x̄ = A + (Σfd / Σf)",
        "x̄ = 35 + (150 / 50)",
        "x̄ = 35 + 3 = 38"
      ),
      finalValue = "38"
    ),
    MathStatItem(
      id = "stat_11_02",
      grade = "11",
      title = "සම්භාවිතා රුක් සටහන් (Tree Diagrams)",
      method = "ප්‍රතිස්ථාපනය රහිත හා සහිත සිදුවීම්",
      formula = "ස්වායත්ත සිදුවීම්: P(A ∩ B) = P(A) × P(B)",
      keyPoints = listOf(
        "ප්‍රතිස්ථාපනය රහිත විට දෙවන වටයේ මුළු සාම්පල සංඛ්‍යාව 1කින් අඩුවේ",
        "එක් එක් අත්තෙහි සම්භාවිතා එකතුව සැමවිටම 1 කි",
        "රුක් සටහනේ කෙළවරේ අනුරූප සම්භාවිතා ගුණ කිරීමෙන් ප්‍රතිඵල සම්භාවිතාව ලැබේ"
      ),
      workedExampleQuestion = "රතු කැට 3ක් සහ නිල් කැට 2ක් ඇති බෑගයකින් නැවත නොදමා අහඹු ලෙස කැට 2ක් එකවර ගනී. කැට 2ම රතු වීමේ සම්භාවිතාව සොයන්න.",
      solutionSteps = listOf(
        "මුළු කැට ගණන = 3 + 2 = 5",
        "පළමු කැටය රතු වීමේ සම්භාවිතාව P(R₁) = 3/5",
        "නැවත නොදමන බැවින් ඉතිරි කැට ගණන 4කි. ඉතිරි රතු කැට ගණන 2කි.",
        "දෙවන කැටය රතු වීමේ සම්භාවිතාව P(R₂) = 2/4 = 1/2",
        "කැට 2ම රතු වීමේ සම්භාවිතාව = (3/5) × (2/4) = 6/20 = 3/10"
      ),
      finalValue = "3/10 (හෝ 0.3)"
    )
  )

  // 6. RAPID-FIRE MCQ & SHORT PROBLEMS (Grade 10 & 11)
  val rapidProblems = listOf(
    MathRapidProblem(
      id = "mcq_10_01",
      grade = "10",
      unitName = "වීජීය ප්‍රකාශන",
      question = "2x² - 18 හි සාධක නිවැරදිව දක්වා ඇත්තේ කුමන පිළිතුරේද?",
      options = listOf(
        "(2x - 6)(x + 3)",
        "2(x - 3)(x + 3)",
        "(x - 9)(x + 9)",
        "2(x - 9)"
      ),
      correctIndex = 1,
      stepByStepExplanation = "2 පොදු සාධකයක් බැවින්: 2(x² - 9) = 2(x² - 3²) = 2(x - 3)(x + 3)."
    ),
    MathRapidProblem(
      id = "mcq_10_02",
      grade = "10",
      unitName = "ත්‍රිකෝණ කෝණ",
      question = "සමපාද ත්‍රිකෝණයක එක් බාහිර කෝණයක විශාලත්වය කොපමණද?",
      options = listOf(
        "60°",
        "90°",
        "120°",
        "180°"
      ),
      correctIndex = 2,
      stepByStepExplanation = "සමපාද ත්‍රිකෝණයක අභ්‍යන්තර කෝණයක් 60° කි. බාහිර කෝණය = 180° - 60° = 120° (සරල රේඛාවක බද්ධ කෝණ)."
    ),
    MathRapidProblem(
      id = "mcq_10_03",
      grade = "10",
      unitName = "ප්‍රතිශත හා පොලිය",
      question = "රු. 10,000 කට 10% වාර්ෂික සුළු පොලිය යටතේ වසර 2 කදී ලැබෙන මුළු මුදල කොපමණද?",
      options = listOf(
        "රු. 1,000",
        "රු. 2,000",
        "රු. 11,000",
        "රු. 12,000"
      ),
      correctIndex = 3,
      stepByStepExplanation = "වසරක පොලිය = 10,000 × 10% = 1,000. වසර 2ක පොලිය = 2,000. මුළු මුදල = 10,000 + 2,000 = රු. 12,000."
    ),
    MathRapidProblem(
      id = "mcq_11_01",
      grade = "11",
      unitName = "වර්ගජ සමීකරණ",
      question = "x² - 5x + 6 = 0 සමීකරණයේ මූල (විසඳුම්) දෙක වන්නේ,",
      options = listOf(
        "x = -2 හෝ x = -3",
        "x = 2 හෝ x = 3",
        "x = 1 හෝ x = 6",
        "x = -1 හෝ x = -6"
      ),
      correctIndex = 1,
      stepByStepExplanation = "ගුණිතය +6 ද එකතුව -5 ද වන සංඛ්‍යා: -2 සහ -3. එබැවින් (x - 2)(x - 3) = 0 ➔ x = 2 හෝ x = 3."
    ),
    MathRapidProblem(
      id = "mcq_11_02",
      grade = "11",
      unitName = "වෘත්ත ප්‍රමේය",
      question = "අර්ධ වෘත්තයක පිහිටි කෝණයක විශාලත්වය කොපමණද?",
      options = listOf(
        "45°",
        "60°",
        "90°",
        "180°"
      ),
      correctIndex = 2,
      stepByStepExplanation = "අර්ධ වෘත්තයක කෝණය සෘජුකෝණයක් (90°) වේ. විෂ්කම්භය මඟින් පරිධිය මත ආපාතනය කරන කෝණය 90° කි."
    ),
    MathRapidProblem(
      id = "mcq_11_03",
      grade = "11",
      unitName = "සම්භාවිතාව",
      question = "සාධාරණ දාදු කැටයක් එක්වරක් උඩ දැමූ විට ඉරට්ටේ ප්‍රථමක සංඛ්‍යාවක් ලැබීමේ සම්භාවිතාව කොපමණද?",
      options = listOf(
        "1/6",
        "2/6 (1/3)",
        "3/6 (1/2)",
        "0"
      ),
      correctIndex = 0,
      stepByStepExplanation = "දාදු කැටයේ ප්‍රතිඵල = {1, 2, 3, 4, 5, 6}. ඉරට්ටේ ප්‍රථමක සංඛ්‍යාව වන්නේ 2 පමණි. එබැවින් සම්භාවිතාව = 1/6."
    )
  )
}

// =============================================================
// COMPACT & EXPANDABLE CARD VIEWS FOR MATHEMATICS SUBJECT PAGE
// =============================================================

@Composable
fun MathGrade10And11MasterHub(
  currentGrade: String = "10"
) {
  var selectedGrade by remember {
    mutableStateOf(if (currentGrade == "11") MathHubGradeFilter.GRADE_11 else MathHubGradeFilter.GRADE_10)
  }
  var selectedModule by remember { mutableStateOf<MathHubModuleType?>(null) }
  var isFullScreenOpen by remember { mutableStateOf(false) }

  // Main Container with dark vibrant math aesthetics
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    border = BorderStroke(1.2.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("math_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Header Row with Full Screen Action
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f, fill = false)
        ) {
          Text("📐", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "10 & 11 ගණිතය විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Text(
              text = "ප්‍රමේය සාධන • ප්‍රස්ථාර • ත්‍රිකෝණමිතිය • වාරික ණය • MCQs",
              color = Color(0xFFBAE6FD),
              fontSize = 9.sp,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }

        Spacer(modifier = Modifier.width(6.dp))

        // Fullscreen Toggle Button
        IconButton(
          onClick = { isFullScreenOpen = true },
          modifier = Modifier
            .size(32.dp)
            .background(Color(0xFF0284C7), RoundedCornerShape(8.dp))
            .testTag("math_hub_fullscreen_btn")
        ) {
          Icon(
            Icons.Default.Fullscreen,
            contentDescription = "පූර්ණ තිරය",
            tint = Color.White,
            modifier = Modifier.size(18.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Grade Toggle Pills: 10 ශ්‍රේණිය vs 11 ශ්‍රේණිය
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(8.dp))
          .background(Color(0xFF1E293B))
          .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        MathHubGradeFilter.values().forEach { g ->
          val isSelected = selectedGrade == g
          Surface(
            onClick = { selectedGrade = g },
            shape = RoundedCornerShape(6.dp),
            color = if (isSelected) Color(0xFF0284C7) else Color.Transparent,
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(vertical = 5.dp),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (g == MathHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය (Grade 10)" else "📙 11 ශ්‍රේණිය (Grade 11)",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF94A3B8)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Compact Module Selector Strip
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        items(MathHubModuleType.values()) { mod ->
          val isSelected = selectedModule == mod
          Surface(
            onClick = {
              selectedModule = if (isSelected) null else mod
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) mod.badgeColor else Color(0xFF1E293B),
            border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF334155))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(mod.icon, fontSize = 11.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = mod.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Active Content Section
      val activeGradeStr = selectedGrade.gradeStr
      when (selectedModule) {
        MathHubModuleType.GEOMETRY -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.geometryTheorems.filter { it.grade == activeGradeStr }
          }
          MathGeometrySubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.ALGEBRA -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.algebraItems.filter { it.grade == activeGradeStr }
          }
          MathAlgebraSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.TRIGONOMETRY -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.trigAndMensurationItems.filter { it.grade == activeGradeStr }
          }
          MathTrigSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.FINANCIAL -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.financialMathItems.filter { it.grade == activeGradeStr }
          }
          MathFinancialSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.STATISTICS -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.statAndProbItems.filter { it.grade == activeGradeStr }
          }
          MathStatSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.CONSTRUCTIONS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.constructionsList.filter { it.grade == activeGradeStr }
          }
          MathConstructionsSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.LOGARITHMS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.logarithmsList.filter { it.grade == activeGradeStr }
          }
          MathLogarithmsSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.SETS_VENN -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.vennDiagramsList.filter { it.grade == activeGradeStr }
          }
          MathVennSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.PROGRESSIONS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.progressionsList.filter { it.grade == activeGradeStr }
          }
          MathProgressionsSubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.MATRICES_INEQ -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.matricesAndIneqList.filter { it.grade == activeGradeStr }
          }
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .background(Color(0xFF1E1B4B))
              .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Text(
              text = "🔲 $activeGradeStr ශ්‍රේණිය - න්‍යාස සහ සරල අසමානතා",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFA5B4FC)
            )
            items.forEach { itm ->
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF312E81),
                border = BorderStroke(1.dp, Color(0xFF6366F1)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(8.dp)) {
                  Text(itm.category, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(itm.conceptOrRules, fontSize = 9.sp, color = Color(0xFFC7D2FE))
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("ක්‍රියාවලිය: ${itm.sampleOperation}", fontSize = 9.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  itm.solutionSteps.forEach { s -> Text("• $s", fontSize = 8.5.sp, color = Color.White) }
                  Spacer(modifier = Modifier.height(3.dp))
                  Text("නිගමනය: ${itm.conclusion}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                }
              }
            }
          }
        }
        MathHubModuleType.VELOCITY_GRAPHS -> {
          val items = remember(activeGradeStr) {
            MathAdvancedSyllabusRepository.velocityGraphsList.filter { it.grade == activeGradeStr }
          }
          MathVelocitySubSection(items = items, grade = activeGradeStr)
        }
        MathHubModuleType.EXAM_TIPS -> {
          MathExamSecretsSubSection(items = MathAdvancedSyllabusRepository.examSecretsList)
        }
        MathHubModuleType.RAPID_MCQ -> {
          val items = remember(activeGradeStr) {
            MathGrade1011SyllabusRepository.rapidProblems.filter { it.grade == activeGradeStr }
          }
          MathRapidProblemSubSection(items = items, grade = activeGradeStr)
        }
        null -> {
          // Default Overview Row with Quick Feature Buttons
          MathQuickOverviewRow(
            grade = activeGradeStr,
            onSelectModule = { selectedModule = it },
            onOpenFullScreen = { isFullScreenOpen = true }
          )
        }
      }
    }
  }

  // Full Screen Interactive Dialog
  if (isFullScreenOpen) {
    MathFullScreenModal(
      initialGrade = selectedGrade,
      onDismiss = { isFullScreenOpen = false }
    )
  }
}

// -------------------------------------------------------------
// COMPACT QUICK OVERVIEW ROW (MINIMAL HEIGHT ON MAIN SCREEN)
// -------------------------------------------------------------

@Composable
private fun MathQuickOverviewRow(
  grade: String,
  onSelectModule: (MathHubModuleType) -> Unit,
  onOpenFullScreen: () -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "📐",
        title = "ප්‍රමේය සාධන",
        subtitle = "$grade ශ්‍රේණිය ජ්‍යාමිතිය",
        color = Color(0xFF0284C7),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.GEOMETRY) }
      )
      MathFeatureQuickButton(
        icon = "📈",
        title = "වර්ගජ ප්‍රස්ථාර",
        subtitle = "හැරවුම් ලක්ෂ්‍ය & විසඳුම්",
        color = Color(0xFFD97706),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.ALGEBRA) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "💰",
        title = "වාරික ණය & පොලී",
        subtitle = "හීනවන ශේෂ සූත්‍ර",
        color = Color(0xFFE11D48),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.FINANCIAL) }
      )
      MathFeatureQuickButton(
        icon = "📊",
        title = "සංඛ්‍යානය & රුක්",
        subtitle = "උපකල්පිත මධ්‍යන්‍ය",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.STATISTICS) }
      )
      MathFeatureQuickButton(
        icon = "🎯",
        title = "MCQs",
        subtitle = "Rapid O/L",
        color = Color(0xFF2563EB),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.RAPID_MCQ) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      MathFeatureQuickButton(
        icon = "📏",
        title = "නිර්මාණ",
        subtitle = "කෝණ & වෘත්ත",
        color = Color(0xFF0D9488),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.CONSTRUCTIONS) }
      )
      MathFeatureQuickButton(
        icon = "🧮",
        title = "ලඝුගණක",
        subtitle = "වගු & අංකනය",
        color = Color(0xFFF59E0B),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.LOGARITHMS) }
      )
      MathFeatureQuickButton(
        icon = "⭕",
        title = "කුලක/ශ්‍රේඪි",
        subtitle = "වෙන් රූප & AP/GP",
        color = Color(0xFF7C3AED),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.SETS_VENN) }
      )
      MathFeatureQuickButton(
        icon = "💡",
        title = "Marking",
        subtitle = "රහස් & වැරදි 20",
        color = Color(0xFFCA8A04),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(MathHubModuleType.EXAM_TIPS) }
      )
    }

    // Interactive Quick Solvers Mini-Bar
    Surface(
      shape = RoundedCornerShape(8.dp),
      color = Color(0xFF1E293B),
      border = BorderStroke(1.dp, Color(0xFF334155)),
      modifier = Modifier
        .fillMaxWidth()
        .clickable { onOpenFullScreen() }
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("⚡", fontSize = 12.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "පියවරෙන් පියවර විසඳුම් & සූත්‍ර ගණක (Full-Screen Solver)",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8)
          )
        }
        Text(
          text = "විවෘත කරන්න ➔",
          fontSize = 9.sp,
          color = Color.White,
          fontWeight = FontWeight.SemiBold
        )
      }
    }
  }
}

@Composable
private fun MathFeatureQuickButton(
  icon: String,
  title: String,
  subtitle: String,
  color: Color,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Surface(
    onClick = onClick,
    shape = RoundedCornerShape(8.dp),
    color = color.copy(alpha = 0.2f),
    border = BorderStroke(1.dp, color.copy(alpha = 0.5f)),
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 11.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = title,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      Text(
        text = subtitle,
        fontSize = 8.sp,
        color = Color(0xFFBAE6FD),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// -------------------------------------------------------------
// 1. GEOMETRY THEOREMS DETAILS SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathGeometrySubSection(
  items: List<MathTheoremItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF032541))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "📐 $grade ශ්‍රේණිය - ජ්‍යාමිතික ප්‍රමේයයන්, සාධන සහ විලෝම",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF7DD3FC)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF082F49),
        border = BorderStroke(1.dp, Color(0xFF0284C7)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = item.title,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFF0284C7)
            ) {
              Text(
                text = item.theoremNumber,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = "ප්‍රකාශය: ${item.statement}",
            fontSize = 9.5.sp,
            color = Color(0xFFE0F2FE)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            if (item.givenData.isNotBlank()) {
              Text("දත්තය: ${item.givenData}", fontSize = 9.sp, color = Color(0xFFBAE6FD))
            }
            if (item.construction.isNotBlank()) {
              Text("නිර්මාණය: ${item.construction}", fontSize = 9.sp, color = Color(0xFFFDE047))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("සාධනය පියවර:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            item.proofSteps.forEach { step ->
              Text("• $step", fontSize = 8.5.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "ආදර්ශ ගැටලුව: ${item.exampleProblem}",
              fontSize = 8.5.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFFFED7AA)
            )
            Text(
              text = "විසඳුම: ${item.exampleSolution}",
              fontSize = 8.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4ADE80)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text("💡 විභාග ඉඟිය: ${item.examTip}", fontSize = 8.sp, color = Color(0xFFBAE6FD))
          } else {
            Text(
              text = "සාධන පියවර & ආදර්ශ ගැටලු බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.sp,
              color = Color(0xFF38BDF8).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 2. ALGEBRA & GRAPHS SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathAlgebraSubSection(
  items: List<MathAlgebraItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF2E1065))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "📈 $grade ශ්‍රේණිය - වීජ ගණිතය, වර්ගජ සමීකරණ සහ ප්‍රස්ථාර",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFFDDD6FE)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF3B0764),
        border = BorderStroke(1.dp, Color(0xFF9333EA)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(
            text = item.topic,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "සූත්‍රය / ප්‍රකාශනය: ${item.formula}",
            fontSize = 10.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Text("මූලධර්මය: ${item.conceptSummary}", fontSize = 9.sp, color = Color(0xFFF3E8FF))
            Spacer(modifier = Modifier.height(4.dp))
            Text("පියවරෙන් පියවර විසඳීම:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA855F7))
            item.steps.forEach { step ->
              Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("ගැටලුව: ${item.sampleQuestion}", fontSize = 8.5.sp, color = Color(0xFFFBBF24))
            item.workedSolution.forEach { sol ->
              Text(sol, fontSize = 8.5.sp, color = Color(0xFFE9D5FF))
            }
            Text(
              text = "පිළිතුර: ${item.finalResult}",
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4ADE80)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text("⚠️ නිතර සිදුවන වැරදි: ${item.commonPitfalls}", fontSize = 8.sp, color = Color(0xFFFCA5A5))
          } else {
            Text(
              text = "පියවර, විසඳූ ගැටලු & වැරදි වැළකීමේ ක්‍රම බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.sp,
              color = Color(0xFFC084FC).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 3. TRIGONOMETRY & MENSURATION SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathTrigSubSection(
  items: List<MathTrigItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF064E3B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "📐 $grade ශ්‍රේණිය - ත්‍රිකෝණමිතිය, මිනුම් & පරිමාව",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF6EE7B7)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF047857),
        border = BorderStroke(1.dp, Color(0xFF10B981)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = item.title,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFF059669)
            ) {
              Text(
                text = item.subCategory,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = "සූත්‍රය: ${item.formula}",
            fontSize = 10.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Text("සූත්‍ර විවරණය: ${item.formulaExplanation}", fontSize = 9.sp, color = Color(0xFFA7F3D0))
            Spacer(modifier = Modifier.height(4.dp))
            Text("ගැටලුව: ${item.questionText}", fontSize = 8.5.sp, color = Color(0xFFFDE68A))
            item.stepByStepWorking.forEach { step ->
              Text("• $step", fontSize = 8.5.sp, color = Color.White)
            }
            Text(
              text = "පිළිතුර: ${item.finalAnswer}",
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4ADE80)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text("භාවිතය: ${item.practicalApplication}", fontSize = 8.sp, color = Color(0xFFD1FAE5))
          } else {
            Text(
              text = "පියවරෙන් පියවර විසඳුම සහ ප්‍රායෝගික භාවිතය බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.sp,
              color = Color(0xFF6EE7B7).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 4. FINANCIAL MATH SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathFinancialSubSection(
  items: List<MathFinancialItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF4C0519))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "💰 $grade ශ්‍රේණිය - මූල්‍ය ගණිතය, වාරික ණය සහ බදු",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFFFDA4AF)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF881337),
        border = BorderStroke(1.dp, Color(0xFFBE123C)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = item.title,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFFBE123C)
            ) {
              Text(
                text = item.category,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = "සූත්‍රය: ${item.formula}",
            fontSize = 9.5.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Text("නීති & ක්‍රමවේදය: ${item.rulesSummary}", fontSize = 9.sp, color = Color(0xFFFEE2E2))
            Spacer(modifier = Modifier.height(4.dp))
            Text("ගැටලුව: ${item.problemText}", fontSize = 8.5.sp, color = Color(0xFFFED7AA))
            item.calculationSteps.forEach { step ->
              Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
            }
            Text(
              text = item.answer,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4ADE80)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text("💡 විභාග උපදෙස: ${item.examAdvice}", fontSize = 8.sp, color = Color(0xFFFFD1D1))
          } else {
            Text(
              text = "ගණනය කිරීමේ පියවර සහ ලකුණු ලබාගන්නා ආකාරය බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.sp,
              color = Color(0xFFFDA4AF).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 5. STATISTICS & PROBABILITY SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathStatSubSection(
  items: List<MathStatItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF1E1B4B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "📊 $grade ශ්‍රේණිය - සංඛ්‍යානය සහ සම්භාවිතා රුක් සටහන්",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFFC7D2FE)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF312E81),
        border = BorderStroke(1.dp, Color(0xFF4F46E5)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(
            text = item.title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "සූත්‍රය: ${item.formula}",
            fontSize = 9.5.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFDE047)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            item.keyPoints.forEach { pt ->
              Text("• $pt", fontSize = 8.5.sp, color = Color(0xFFE0E7FF))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("ගැටලුව: ${item.workedExampleQuestion}", fontSize = 8.5.sp, color = Color(0xFFFEF08A))
            item.solutionSteps.forEach { step ->
              Text("➔ $step", fontSize = 8.5.sp, color = Color.White)
            }
            Text(
              text = "අවසන් අගය: ${item.finalValue}",
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF4ADE80)
            )
          } else {
            Text(
              text = "සවිස්තර පියවර සහ රුක් සටහන් නීති බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.sp,
              color = Color(0xFFA5B4FC).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// -------------------------------------------------------------
// 6. RAPID-FIRE MCQ SUB-SECTION
// -------------------------------------------------------------

@Composable
private fun MathRapidProblemSubSection(
  items: List<MathRapidProblem>,
  grade: String
) {
  var currentIndex by remember(grade) { mutableStateOf(0) }
  var selectedOption by remember(currentIndex, grade) { mutableStateOf<Int?>(null) }
  var isSubmitted by remember(currentIndex, grade) { mutableStateOf(false) }

  if (items.isEmpty()) {
    Text(
      text = "මෙම ශ්‍රේණිය සඳහා ගැටලු ඉක්මනින් එක්වේ.",
      color = Color.White,
      fontSize = 11.sp,
      modifier = Modifier.padding(8.dp)
    )
    return
  }

  val currentItem = items[currentIndex.coerceIn(0, items.size - 1)]

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF172554))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "🎯 $grade ගණිතය - O/L Rapid-Fire ප්‍රශ්නාවලිය",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF93C5FD)
      )
      Text(
        text = "${currentIndex + 1}/${items.size}",
        fontSize = 9.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF60A5FA)
      )
    }

    Text(
      text = "ඒකකය: ${currentItem.unitName}",
      fontSize = 8.5.sp,
      color = Color(0xFFBFDBFE)
    )

    Text(
      text = currentItem.question,
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )

    Spacer(modifier = Modifier.height(2.dp))

    // Options
    currentItem.options.forEachIndexed { optIndex, optionText ->
      val isChosen = selectedOption == optIndex
      val isCorrect = optIndex == currentItem.correctIndex
      val optionBg = when {
        isSubmitted && isCorrect -> Color(0xFF059669)
        isSubmitted && isChosen && !isCorrect -> Color(0xFFDC2626)
        isChosen -> Color(0xFF2563EB)
        else -> Color(0xFF1E3A8A)
      }

      Surface(
        onClick = {
          if (!isSubmitted) selectedOption = optIndex
        },
        shape = RoundedCornerShape(6.dp),
        color = optionBg,
        border = BorderStroke(1.dp, if (isChosen) Color.White else Color(0xFF1D4ED8)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "(${optIndex + 1})",
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = optionText,
            fontSize = 10.sp,
            color = Color.White
          )
        }
      }
    }

    if (!isSubmitted) {
      Button(
        onClick = {
          if (selectedOption != null) isSubmitted = true
        },
        enabled = selectedOption != null,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.align(Alignment.End),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
      ) {
        Text("පිළිතුර තහවුරු කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
      }
    } else {
      Surface(
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFF0F172A),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(6.dp)) {
          Text(
            text = if (selectedOption == currentItem.correctIndex) "✅ නිවැරදියි!" else "❌ වැරදියි! නිවැරදි පිළිතුර: (${currentItem.correctIndex + 1})",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = if (selectedOption == currentItem.correctIndex) Color(0xFF4ADE80) else Color(0xFFF87171)
          )
          Text(
            text = "පියවරෙන් පියවර විවරණය: ${currentItem.stepByStepExplanation}",
            fontSize = 9.sp,
            color = Color(0xFFBAE6FD)
          )
        }
      }

      if (currentIndex < items.size - 1) {
        Button(
          onClick = {
            currentIndex++
            selectedOption = null
            isSubmitted = false
          },
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B82F6)),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.align(Alignment.End),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        ) {
          Text("මීළඟ ගැටලුව ➔", fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

// =============================================================
// FULL-SCREEN IMMERSIVE & SCROLLABLE MATHEMATICS SUITE
// =============================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathFullScreenModal(
  initialGrade: MathHubGradeFilter = MathHubGradeFilter.GRADE_10,
  onDismiss: () -> Unit
) {
  var currentGrade by remember { mutableStateOf(initialGrade) }
  var selectedTab by remember { mutableStateOf(0) }
  var searchQuery by remember { mutableStateOf("") }

  // Interactive Solvers State
  var quadA by remember { mutableStateOf("1") }
  var quadB by remember { mutableStateOf("-5") }
  var quadC by remember { mutableStateOf("6") }
  var quadResult by remember { mutableStateOf<String?>(null) }

  var loanAmount by remember { mutableStateOf("24000") }
  var loanRate by remember { mutableStateOf("12") }
  var loanMonths by remember { mutableStateOf("12") }
  var loanResult by remember { mutableStateOf<String?>(null) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = {
            Column {
              Text(
                text = "10 & 11 ගණිතය පූර්ණ නිර්දේශය (Full-Screen)",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
              Text(
                text = "සියලු ප්‍රමේයයන් • සූත්‍ර • පියවරෙන් පියවර විසඳුම් ගණක",
                fontSize = 10.sp,
                color = Color(0xFFBAE6FD)
              )
            }
          },
          navigationIcon = {
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0F172A)
          )
        )
      },
      containerColor = Color(0xFF020617)
    ) { padding ->
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        // Grade Selector Pill Bar
        item {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp))
              .background(Color(0xFF1E293B))
              .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            MathHubGradeFilter.values().forEach { g ->
              val isSelected = currentGrade == g
              Surface(
                onClick = { currentGrade = g },
                shape = RoundedCornerShape(8.dp),
                color = if (isSelected) Color(0xFF0284C7) else Color.Transparent,
                modifier = Modifier.weight(1f)
              ) {
                Box(
                  modifier = Modifier.padding(vertical = 8.dp),
                  contentAlignment = Alignment.Center
                ) {
                  Text(
                    text = if (g == MathHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය (Grade 10)" else "📙 11 ශ්‍රේණිය (O/L Grade 11)",
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                    color = if (isSelected) Color.White else Color(0xFF94A3B8)
                  )
                }
              }
            }
          }
        }

        // Section Tabs Row
        item {
          val tabs = listOf("ජ්‍යාමිතිය", "වීජ ගණිතය", "මිනුම්", "මූල්‍ය", "සංඛ්‍යානය", "නිර්මාණ", "ලඝුගණක", "කුලක", "ශ්‍රේඪි", "ප්‍රස්ථාර/න්‍යාස", "Marking රහස්", "⚡ ගණක යන්ත්‍ර")
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            items(tabs.size) { idx ->
              val isSel = selectedTab == idx
              Surface(
                onClick = { selectedTab = idx },
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) Color(0xFF38BDF8) else Color(0xFF1E293B),
                border = BorderStroke(1.dp, if (isSel) Color.White else Color(0xFF334155))
              ) {
                Text(
                  text = tabs[idx],
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (isSel) Color(0xFF0F172A) else Color.White,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
              }
            }
          }
        }

        val activeGrade = currentGrade.gradeStr

        when (selectedTab) {
          0 -> {
            // GEOMETRY THEOREMS IN FULL DETAIL
            item {
              Text(
                text = "📐 $activeGrade ශ්‍රේණිය ජ්‍යාමිතික ප්‍රමේයයන් සහ සම්පූර්ණ සාධන",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
            }
            val theorems = MathGrade1011SyllabusRepository.geometryTheorems.filter { it.grade == activeGrade }
            items(theorems) { thm ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(thm.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0284C7)) {
                      Text(thm.theoremNumber, fontSize = 9.sp, color = Color.White, modifier = Modifier.padding(4.dp, 2.dp))
                    }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("ප්‍රකාශය: ${thm.statement}", fontSize = 11.sp, color = Color(0xFFBAE6FD), fontWeight = FontWeight.SemiBold)
                  Spacer(modifier = Modifier.height(4.dp))
                  if (thm.givenData.isNotBlank()) {
                    Text("දත්තය: ${thm.givenData}", fontSize = 10.sp, color = Color(0xFFE2E8F0))
                  }
                  if (thm.construction.isNotBlank()) {
                    Text("නිර්මාණය: ${thm.construction}", fontSize = 10.sp, color = Color(0xFFFDE047))
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("සාධනය පියවර:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                  thm.proofSteps.forEach { step ->
                    Text("• $step", fontSize = 10.sp, color = Color.White)
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF1E293B), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ආදර්ශ ගැටලුව: ${thm.exampleProblem}", fontSize = 10.sp, color = Color(0xFFFED7AA))
                      Text("විසඳුම: ${thm.exampleSolution}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          1 -> {
            // ALGEBRA
            item {
              Text(
                text = "📈 $activeGrade ශ්‍රේණිය වීජ ගණිතය & වර්ගජ ශ්‍රිත ප්‍රස්ථාර",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF59E0B)
              )
            }
            val algItems = MathGrade1011SyllabusRepository.algebraItems.filter { it.grade == activeGrade }
            items(algItems) { alg ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF6366F1).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(alg.topic, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${alg.formula}", fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(alg.conceptSummary, fontSize = 10.sp, color = Color(0xFFC7D2FE))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("පියවරෙන් පියවර විසඳීම:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF818CF8))
                  alg.steps.forEach { s -> Text("➔ $s", fontSize = 10.sp, color = Color.White) }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF312E81), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${alg.sampleQuestion}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      alg.workedSolution.forEach { ws -> Text(ws, fontSize = 9.5.sp, color = Color.White) }
                      Text("අවසාන පිළිතුර: ${alg.finalResult}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          2 -> {
            // TRIGONOMETRY & MENSURATION
            item {
              Text(
                text = "📐 $activeGrade ශ්‍රේණිය ත්‍රිකෝණමිතිය, මිනුම් සහ දිගංශය",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF10B981)
              )
            }
            val trigs = MathGrade1011SyllabusRepository.trigAndMensurationItems.filter { it.grade == activeGrade }
            items(trigs) { trg ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(trg.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${trg.formula}", fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(trg.formulaExplanation, fontSize = 10.sp, color = Color(0xFFA7F3D0))
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF047857), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${trg.questionText}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      trg.stepByStepWorking.forEach { step -> Text("• $step", fontSize = 9.5.sp, color = Color.White) }
                      Text("පිළිතුර: ${trg.finalAnswer}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          3 -> {
            // FINANCIAL MATH
            item {
              Text(
                text = "💰 $activeGrade ශ්‍රේණිය මූල්‍ය ගණිතය සහ බදු ගණනය",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF43F5E)
              )
            }
            val fins = MathGrade1011SyllabusRepository.financialMathItems.filter { it.grade == activeGrade }
            items(fins) { fin ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4C0519)),
                border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(fin.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${fin.formula}", fontSize = 10.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  Text("නීති: ${fin.rulesSummary}", fontSize = 10.sp, color = Color(0xFFFECDD3))
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF881337), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${fin.problemText}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      fin.calculationSteps.forEach { step -> Text("➔ $step", fontSize = 9.5.sp, color = Color.White) }
                      Text(fin.answer, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          4 -> {
            // STATISTICS
            item {
              Text(
                text = "📊 $activeGrade ශ්‍රේණිය සංඛ්‍යානය සහ සම්භාවිතාව",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA855F7)
              )
            }
            val stats = MathGrade1011SyllabusRepository.statAndProbItems.filter { it.grade == activeGrade }
            items(stats) { st ->
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.6f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(st.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                  Spacer(modifier = Modifier.height(4.dp))
                  Text("සූත්‍රය: ${st.formula}", fontSize = 10.5.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                  Spacer(modifier = Modifier.height(6.dp))
                  st.keyPoints.forEach { pt -> Text("• $pt", fontSize = 9.5.sp, color = Color(0xFFE0E7FF)) }
                  Spacer(modifier = Modifier.height(6.dp))
                  Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFF312E81), modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text("ගැටලුව: ${st.workedExampleQuestion}", fontSize = 10.sp, color = Color(0xFFFDE68A))
                      st.solutionSteps.forEach { step -> Text("➔ $step", fontSize = 9.5.sp, color = Color.White) }
                      Text("ප්‍රතිඵලය: ${st.finalValue}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          5 -> {
            // CONSTRUCTIONS
            item {
              val items = MathAdvancedSyllabusRepository.constructionsList.filter { it.grade == activeGrade }
              MathConstructionsSubSection(items = items, grade = activeGrade)
            }
          }

          6 -> {
            // LOGARITHMS
            item {
              val items = MathAdvancedSyllabusRepository.logarithmsList.filter { it.grade == activeGrade }
              MathLogarithmsSubSection(items = items, grade = activeGrade)
            }
          }

          7 -> {
            // SETS & VENN DIAGRAMS
            item {
              val items = MathAdvancedSyllabusRepository.vennDiagramsList.filter { it.grade == activeGrade }
              MathVennSubSection(items = items, grade = activeGrade)
            }
          }

          8 -> {
            // PROGRESSIONS (AP & GP)
            item {
              val items = MathAdvancedSyllabusRepository.progressionsList.filter { it.grade == activeGrade }
              MathProgressionsSubSection(items = items, grade = activeGrade)
            }
          }

          9 -> {
            // VELOCITY-TIME GRAPHS & MATRICES
            item {
              val vels = MathAdvancedSyllabusRepository.velocityGraphsList.filter { it.grade == activeGrade }
              MathVelocitySubSection(items = vels, grade = activeGrade)
            }
            item {
              val mats = MathAdvancedSyllabusRepository.matricesAndIneqList.filter { it.grade == activeGrade }
              Column(
                modifier = Modifier
                  .fillMaxWidth()
                  .clip(RoundedCornerShape(8.dp))
                  .background(Color(0xFF1E1B4B))
                  .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                Text(
                  text = "🔲 $activeGrade ශ්‍රේණිය - න්‍යාස සහ අසමානතා සවිස්තරාත්මක සටහන්",
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color(0xFFA5B4FC)
                )
                mats.forEach { itm ->
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF312E81),
                    border = BorderStroke(1.dp, Color(0xFF6366F1)),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                      Text(itm.category, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(itm.conceptOrRules, fontSize = 9.sp, color = Color(0xFFC7D2FE))
                      Spacer(modifier = Modifier.height(4.dp))
                      Text("ක්‍රියාවලිය: ${itm.sampleOperation}", fontSize = 9.sp, fontFamily = FontFamily.Monospace, color = Color(0xFFFDE047))
                      itm.solutionSteps.forEach { s -> Text("• $s", fontSize = 8.5.sp, color = Color.White) }
                      Spacer(modifier = Modifier.height(3.dp))
                      Text("නිගමනය: ${itm.conclusion}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                  }
                }
              }
            }
          }

          10 -> {
            // O/L MARKING SCHEME & COMMON MISTAKES
            item {
              MathExamSecretsSubSection(items = MathAdvancedSyllabusRepository.examSecretsList)
            }
          }

          11 -> {
            // INTERACTIVE SOLVERS (QUADRATIC & FINANCIAL)
            item {
              Text(
                text = "⚡ අන්තර්ක්‍රියාකාරී ගණිත විසඳුම් ගණකය (Step-by-Step Solvers)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF38BDF8)
              )
            }

            // 1. Quadratic Equation Solver Card
            item {
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                border = BorderStroke(1.dp, Color(0xFF0284C7)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(
                    text = "1. වර්ගජ සමීකරණ විසඳුම් ගණකය (ax² + bx + c = 0)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    OutlinedTextField(
                      value = quadA,
                      onValueChange = { quadA = it },
                      label = { Text("a", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = quadB,
                      onValueChange = { quadB = it },
                      label = { Text("b", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = quadC,
                      onValueChange = { quadC = it },
                      label = { Text("c", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Button(
                    onClick = {
                      val a = quadA.toDoubleOrNull() ?: 1.0
                      val b = quadB.toDoubleOrNull() ?: 0.0
                      val c = quadC.toDoubleOrNull() ?: 0.0
                      val disc = b * b - 4 * a * c
                      quadResult = if (disc < 0) {
                        "විවේචකය b² - 4ac = $disc < 0 බැවින් තාත්වික මූල නොපවතී."
                      } else {
                        val root1 = (-b + sqrt(disc)) / (2 * a)
                        val root2 = (-b - sqrt(disc)) / (2 * a)
                        "විවේචකය (b² - 4ac) = $disc\n√($disc) = %.2f\nx₁ = %.2f\nx₂ = %.2f".format(sqrt(disc), root1, root2)
                      }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text("විසඳන්න (Calculate Step-by-Step)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }

                  quadResult?.let { res ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      color = Color(0xFF1E293B),
                      shape = RoundedCornerShape(6.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Text(
                        text = res,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF4ADE80),
                        modifier = Modifier.padding(8.dp)
                      )
                    }
                  }
                }
              }
            }

            // 2. Reducing Balance Loan Calculator Card
            item {
              Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                border = BorderStroke(1.dp, Color(0xFF6366F1)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Text(
                    text = "2. හීනවන ශේෂ වාරික ණය ගණකය (Installment Loan)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    OutlinedTextField(
                      value = loanAmount,
                      onValueChange = { loanAmount = it },
                      label = { Text("ණය මුදල", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(1.2f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = loanRate,
                      onValueChange = { loanRate = it },
                      label = { Text("පොලිය %", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(0.9f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                    OutlinedTextField(
                      value = loanMonths,
                      onValueChange = { loanMonths = it },
                      label = { Text("මාස ගණන", color = Color(0xFF94A3B8), fontSize = 10.sp) },
                      modifier = Modifier.weight(0.9f),
                      textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 12.sp),
                      singleLine = true
                    )
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Button(
                    onClick = {
                      val p = loanAmount.toDoubleOrNull() ?: 24000.0
                      val r = loanRate.toDoubleOrNull() ?: 12.0
                      val n = loanMonths.toIntOrNull() ?: 12
                      val monthlyCapital = p / n
                      val monthUnits = (n * (n + 1)) / 2
                      val unitInterest = monthlyCapital * (r / 100.0) * (1.0 / 12.0)
                      val totalInterest = monthUnits * unitInterest
                      val totalPayment = p + totalInterest
                      val monthlyInstallment = totalPayment / n
                      loanResult = "මාස ඒකක ගණන = $monthUnits\nමාසික ණය පියවීම = රු. %.2f\nමුළු පොලිය = රු. %.2f\nගෙවිය යුතු මුළු මුදල = රු. %.2f\nමාසික වාරිකය = රු. %.2f".format(
                        monthlyCapital, totalInterest, totalPayment, monthlyInstallment
                      )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                  ) {
                    Text("වාරිකය ගණනය කරන්න (Calculate)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }

                  loanResult?.let { lRes ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      color = Color(0xFF0F172A),
                      shape = RoundedCornerShape(6.dp),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Text(
                        text = lRes,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(8.dp)
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
