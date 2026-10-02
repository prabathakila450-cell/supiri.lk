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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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

/**
 * 100% ACCURATE O/L SYLLABUS SCIENCE MASTER HUB FOR GRADES 10 & 11
 * Divided strictly by Grade 10 and Grade 11 modules:
 * 1. රසායනික සමීකරණ හා සූත්‍ර තුලනය (Chemical Equations & Formulas)
 * 2. භෞතික විද්‍යා සූත්‍ර සහ ගණිත ගැටලු විසඳනය (Physics Numerical Solvers)
 * 3. ප්‍රායෝගික පරීක්ෂණ සහ නිරීක්ෂණ (Practicals & Observations Guide)
 * 4. ජීව විද්‍යා රූප සටහන් සහ කොටස් නම් කිරීම (Biology Interactive Labeling)
 * 5. Rapid-Fire MCQs Challenge (O/L Paper 1 Model with Explanations)
 */

enum class ScienceHubGradeFilter(val gradeStr: String, val title: String) {
  GRADE_10("10", "10 ශ්‍රේණිය (Grade 10)"),
  GRADE_11("11", "11 ශ්‍රේණිය (Grade 11)")
}

enum class ScienceModuleType(val title: String, val icon: String, val badgeColor: Color) {
  CHEMISTRY("රසායන සමීකරණ තුලනය", "🧪", Color(0xFF0284C7)),
  PHYSICS("භෞතික සූත්‍ර & ගණිත ගැටලු", "⚡", Color(0xFFD97706)),
  PRACTICALS("ප්‍රායෝගික පරීක්ෂණ", "🔬", Color(0xFF059669)),
  BIOLOGY("ජීව විද්‍යා රූප සටහන්", "🫀", Color(0xFFE11D48)),
  MCQ_CHALLENGE("Rapid-Fire MCQs", "🎯", Color(0xFF7C3AED))
}

// -------------------------------------------------------------
// 1. CHEMISTRY EQUATION & FORMULA MODELS
// -------------------------------------------------------------
data class ScienceChemItem(
  val id: String,
  val grade: String,
  val title: String,
  val category: String, // "සූත්‍ර ලිවීම", "තුලනය කිරීම", "ප්‍රතික්‍රියා වර්ගය"
  val reactantsSinhala: String,
  val unbalancedEquation: String,
  val balancedEquation: String,
  val explanation: String,
  val keyPoints: List<String>
)

// -------------------------------------------------------------
// 2. PHYSICS FORMULA & NUMERICAL PROBLEM MODELS
// -------------------------------------------------------------
data class SciencePhysicsItem(
  val id: String,
  val grade: String,
  val unitName: String,
  val formula: String,
  val formulaExplanation: String,
  val problemText: String,
  val stepByStepSolution: List<String>,
  val finalAnswer: String,
  val units: String,
  val examTip: String
)

// -------------------------------------------------------------
// 3. PRACTICAL EXPERIMENT MODELS
// -------------------------------------------------------------
data class SciencePracticalItem(
  val id: String,
  val grade: String,
  val title: String,
  val aim: String,
  val apparatus: List<String>,
  val method: List<String>,
  val observation: String,
  val conclusion: String,
  val examPrecautions: List<String>
)

// -------------------------------------------------------------
// 4. BIOLOGY DIAGRAM & LABELING MODELS
// -------------------------------------------------------------
data class BioLabelPart(
  val labelNumber: String,
  val partName: String,
  val function: String
)

data class ScienceBiologyDiagramItem(
  val id: String,
  val grade: String,
  val diagramTitle: String,
  val systemCategory: String,
  val overview: String,
  val labels: List<BioLabelPart>,
  val examQuestions: List<String>
)

// -------------------------------------------------------------
// 5. RAPID-FIRE MCQ CHALLENGE MODELS
// -------------------------------------------------------------
data class ScienceRapidMcqItem(
  val id: String,
  val grade: String,
  val unitName: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

// =============================================================
// REPOSITORY: 100% ACCURATE O/L SYLLABUS CURATED DATA
// =============================================================
object ScienceGrade1011SyllabusRepository {

  // 1. CHEMISTRY
  val chemistryItems = listOf(
    // Grade 10
    ScienceChemItem(
      id = "chem_10_01",
      grade = "10",
      title = "මැග්නීසියම් වාතයේ දහනය",
      category = "තුලනය කිරීම",
      reactantsSinhala = "මැග්නීසියම් ලෝහය ඔක්සිජන් වායුව සමඟ දහනය වී මැග්නීසියම් ඔක්සයිඩ් සෑදීම",
      unbalancedEquation = "Mg + O₂ ➔ MgO",
      balancedEquation = "2Mg + O₂ ➔ 2MgO",
      explanation = "වම් පස ඔක්සිජන් පරමාණු 2ක් ඇති බැවින් දකුණු පස MgO ඉදිරියට 2 යොදයි. ඉන්පසු මැග්නීසියම් තුලනය කිරීමට වම් පස Mg ඉදිරියට 2 යොදයි.",
      keyPoints = listOf("දප්තිමත් සුදු දැල්ලකින් දැවේ", "සුදු පැහැති භස්මීය අළු (MgO) සාදයි", "සංයෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_02",
      grade = "10",
      title = "කැල්සියම් කාබනේට් අම්ල සමඟ ප්‍රතික්‍රියාව",
      category = "තුලනය කිරීම",
      reactantsSinhala = "හුණුගල් (CaCO₃) තනුක හයිඩ්‍රොක්ලෝරික් අම්ලය (HCl) සමඟ ප්‍රතික්‍රියාව",
      unbalancedEquation = "CaCO₃ + HCl ➔ CaCl₂ + CO₂ + H₂O",
      balancedEquation = "CaCO₃ + 2HCl ➔ CaCl₂ + CO₂ + H₂O",
      explanation = "දකුණු පස Cl පරමාණු 2ක් ඇති බැවින් වම්පස HCl ඉදිරියට 2 යොදයි. එවිට H, Ca, C සහ O පරමාණු සියල්ල දෙපසම තුලනය වේ.",
      keyPoints = listOf("කාබන්ඩයොක්සයිඩ් වායුව පිටවේ (හුණුදියර කිරි පැහැ කරයි)", "බුබුළු දැමීමක් නිරීක්ෂණය වේ", "ලවණයක්, වායුවක් සහ ජලය ලැබේ")
    ),
    ScienceChemItem(
      id = "chem_10_03",
      grade = "10",
      title = "සෝඩියම් ජලය සමඟ ප්‍රතික්‍රියාව",
      category = "ප්‍රතික්‍රියා වර්ගය",
      reactantsSinhala = "සෝඩියම් ලෝහය ජලය සමඟ ක්ෂණිකව ප්‍රතික්‍රියා කර සෝඩියම් හයිඩ්‍රොක්සයිඩ් සහ හයිඩ්‍රජන් වායුව නිපදවීම",
      unbalancedEquation = "Na + H₂O ➔ NaOH + H₂",
      balancedEquation = "2Na + 2H₂O ➔ 2NaOH + H₂",
      explanation = "දකුණු පස H පරමාණු 3ක් ඇති බැවින් H₂O ඉදිරියට 2 දමා NaOH ඉදිරියට 2 දමා Na ඉදිරියට 2 දැමීමෙන් සම්පූර්ණ සමීකරණය තුලනය වේ.",
      keyPoints = listOf("තීව්‍ර තාපදායක ප්‍රතික්‍රියාවකි", "හයිඩ්‍රජන් වායුව පිටවේ ('පොප්' හඬින් දැල්වේ)", "ද්‍රාවණය භස්මීය වේ (රතු ලිට්මස් නිල් වේ)")
    ),
    ScienceChemItem(
      id = "chem_10_04",
      grade = "10",
      title = "යකඩ මූලද්‍රව්‍යය ගෙන්දගම් සමඟ සංයෝජනය",
      category = "සූත්‍ර ලිවීම",
      reactantsSinhala = "යකඩ කුඩු සහ සල්ෆර් රත් කිරීමෙන් අයන්(II) සල්ෆයිඩ් සෑදීම",
      unbalancedEquation = "Fe + S ➔ FeS",
      balancedEquation = "Fe + S ➔ FeS",
      explanation = "යකඩ සංයුජතාව 2 වන අතර සල්ෆර් සංයුජතාව 2 වේ. සංයුජතා හුවමාරු කළ විට Fe₂S₂ සරල අනුපාතය FeS වේ. සමීකරණය ස්වයංක්‍රීයව තුලිතය.",
      keyPoints = listOf("කළු පැහැති ඝන FeS සෑදේ", "චුම්භකයට ආකර්ෂණය නොවේ (සංයෝගයකි)", "සංයෝජන ප්‍රතික්‍රියාවකි")
    ),

    // Grade 11
    ScienceChemItem(
      id = "chem_11_01",
      grade = "11",
      title = "යකඩ මලකෑම සහ ඔක්සිකරණය",
      category = "ප්‍රතික්‍රියා වර්ගය",
      reactantsSinhala = "යකඩ ජලය සහ ඔක්සිජන් හමුවේ මල බැඳීම (ජලීය අයන්(III) ඔක්සයිඩ් සෑදීම)",
      unbalancedEquation = "Fe + O₂ + xH₂O ➔ Fe₂O₃·xH₂O",
      balancedEquation = "4Fe + 3O₂ + 2xH₂O ➔ 2(Fe₂O₃·xH₂O)",
      explanation = "යකඩ ඔක්සිකරණය වී Fe³⁺ සාදන අතර ඔක්සිජන් ඔක්සිහරණය වේ. මලකෑම සඳහා ඔක්සිජන් වායුව සහ ජලය අනිවාර්යයෙන්ම අවශ්‍ය වේ.",
      keyPoints = listOf("රතු-දුඹුරු පැහැ කුඩු සහිත මලකඩ සෑදේ", "විද්‍යුත් රසායනික ක්‍රියාවලියකි", "ගැල්වනයිස් කිරීමෙන්/තීන්ත ආලේපයෙන් වළක්වයි")
    ),
    ScienceChemItem(
      id = "chem_11_02",
      grade = "11",
      title = "ලෝහ විස්ථාපන ප්‍රතික්‍රියාව (CuSO₄ + Zn)",
      category = "තුලනය කිරීම",
      reactantsSinhala = "තඹ(II) සල්ෆේට් ද්‍රාවණයකට සින්ක් ලෝහ කැබැල්ලක් දැමීම",
      unbalancedEquation = "Zn + CuSO₄ ➔ ZnSO₄ + Cu",
      balancedEquation = "Zn + CuSO₄ ➔ ZnSO₄ + Cu",
      explanation = "ක්‍රියාකාරීත්ව ශ්‍රේණියේ තඹට වඩා සින්ක් ඉහළින් පිහිටන බැවින්, සින්ක් මඟින් ද්‍රාවණයේ ඇති Cu²⁺ අයන විස්ථාපනය කර රතු දුඹුරු තඹ තැන්පත් කරයි.",
      keyPoints = listOf("නිල් පැහැ CuSO₄ ද්‍රාවණය අවර්ණ වේ", "සින්ක් මත රතු දුඹුරු තඹ තැන්පත් වේ", "ඒකීය විස්ථාපන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_03",
      grade = "11",
      title = "අම්ල-භස්ම උදාසීනීකරණය (HCl + NaOH)",
      category = "තුලනය කිරීම",
      reactantsSinhala = "හයිඩ්‍රොක්ලෝරික් අම්ලය සහ සෝඩියම් හයිඩ්‍රොක්සයිඩ් උදාසීන වීම",
      unbalancedEquation = "HCl + NaOH ➔ NaCl + H₂O",
      balancedEquation = "HCl + NaOH ➔ NaCl + H₂O",
      explanation = "H⁺(aq) + OH⁻(aq) ➔ H₂O(l) යනු මෙහි ශුද්ධ අයනික සමීකරණයයි. සමාන මවුල ප්‍රමාණ ප්‍රතික්‍රියා කර උදාසීන ලවණයක් හා ජලය සාදයි.",
      keyPoints = listOf("තාපදායක ප්‍රතික්‍රියාවකි", "pH අගය 7 දක්වා ළඟාවේ", "ද්විත්ව විස්ථාපන උදාසීනීකරණයකි")
    ),
    ScienceChemItem(
      id = "chem_11_04",
      grade = "11",
      title = "ග්ලූකෝස් සෛලීය ශ්වසනය (පූර්ණ දහනය)",
      category = "තුලනය කිරීම",
      reactantsSinhala = "ග්ලූකෝස් සෛල තුළ ඔක්සිජන් සමඟ බිඳවැටී ශක්තිය මුදාහැරීම",
      unbalancedEquation = "C₆H₁₂O₆ + O₂ ➔ CO₂ + H₂O + ශක්තිය",
      balancedEquation = "C₆H₁₂O₆ + 6O₂ ➔ 6CO₂ + 6H₂O + 38 ATP",
      explanation = "C පරමාණු 6ක් ඇති බැවින් 6CO₂ වේ. H පරමාණු 12ක් ඇති බැවින් 6H₂O වේ. දකුණු පස මුළු ඔක්සිජන් (6x2 + 6 = 18) තුලනය කිරීමට 6O₂ යොදයි.",
      keyPoints = listOf("සෛලයේ මයිටොකොන්ඩ්‍රියා තුළ සිදුවේ", "වායුගෝලීය ඔක්සිජන් උපයෝගී කරගනී", "ජීවීන්ට අවශ්‍ය ATP ශක්තිය සපයයි")
    )
  )

  // 2. PHYSICS
  val physicsItems = listOf(
    // Grade 10
    SciencePhysicsItem(
      id = "phy_10_01",
      grade = "10",
      unitName = "චලිත සමීකරණ (Equations of Motion)",
      formula = "v = u + at  |  s = ut + ½at²  |  v² = u² + 2as",
      formulaExplanation = "v = අවසාන ප්‍රවේගය, u = ආරම්භක ප්‍රවේගය, a = ත්වරණය, t = කාලය, s = විස්ථාපනය",
      problemText = "නිශ්චලතාවයෙන් ගමන් ආරම්භ කරන මෝටර් රථයක් 2 m s⁻² ඒකාකාර ත්වරණයකින් තත්පර 5ක් ගමන් කරයි. රථය ලබාගන්නා අවසාන ප්‍රවේගය සහ ගමන් කළ දුර සොයන්න.",
      stepByStepSolution = listOf(
        "දත්ත: u = 0, a = 2 m s⁻², t = 5 s",
        "1. අවසාන ප්‍රවේගය (v): v = u + at ➔ v = 0 + (2 × 5) = 10 m s⁻¹",
        "2. ගමන් කළ දුර (s): s = ut + ½at² ➔ s = (0 × 5) + ½ × 2 × (5)²",
        "s = 0 + 1 × 25 = 25 m"
      ),
      finalAnswer = "ප්‍රවේගය = 10 m s⁻¹, දුර = 25 m",
      units = "m s⁻¹ සහ m",
      examTip = "නිශ්චලතාවයෙන් අරඹයි කී විට u = 0 ලෙසත්, තිරිංග යොදා නතර කළා කී විට v = 0 ලෙසත් ගන්න."
    ),
    SciencePhysicsItem(
      id = "phy_10_02",
      grade = "10",
      unitName = "නිව්ටන්ගේ දෙවන නියමය (Newton's 2nd Law)",
      formula = "F = ma",
      formulaExplanation = "F = සම්ප්‍රයුක්ත බලය (N), m = ස්කන්ධය (kg), a = ත්වරණය (m s⁻²)",
      problemText = "ස්කන්ධය 1200 kg වූ මෝටර් රථයකට තත්පර 4ක් තුළ ප්‍රවේගය 10 m s⁻¹ සිට 30 m s⁻¹ දක්වා වැඩි කිරීමට එන්ජිම මඟින් යෙදිය යුතු බලය ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "1. ත්වරණය සෙවීම: a = (v - u) / t",
        "a = (30 - 10) / 4 = 20 / 4 = 5 m s⁻²",
        "2. බලය සෙවීම: F = ma",
        "F = 1200 kg × 5 m s⁻² = 6000 N"
      ),
      finalAnswer = "යෙදිය යුතු බලය = 6000 N (හෝ 6 kN)",
      units = "Newton (N)",
      examTip = "ස්කන්ධය ග්‍රෑම් (g) වලින් දුනහොත් 1000න් බෙදා කිලෝග්‍රෑම් (kg) බවට හරවාගත යුතුය."
    ),
    SciencePhysicsItem(
      id = "phy_10_03",
      grade = "10",
      unitName = "දියර පීඩනය (Hydrostatic Pressure)",
      formula = "P = hρg  සහ  P = F / A",
      formulaExplanation = "P = පීඩනය (Pa හෝ N m⁻²), h = ගැඹුර (m), ρ = ඝනත්වය (kg m⁻³), g = ගුරුත්වජ ත්වරණය (10 m s⁻²)",
      problemText = "ඝනත්වය 1000 kg m⁻³ වූ ජල ටැංකියක පතුලේ සිට 3 m ගැඹුරින් පිහිටි ලක්ෂ්‍යයක ජල පීඩනය ගණනය කරන්න. (g = 10 m s⁻²)",
      stepByStepSolution = listOf(
        "දත්ත: h = 3 m, ρ = 1000 kg m⁻³, g = 10 m s⁻²",
        "P = hρg සූත්‍රය ආදේශය:",
        "P = 3 m × 1000 kg m⁻³ × 10 m s⁻²",
        "P = 30,000 Pa (පැස්කල්) හෙවත් 30 kPa"
      ),
      finalAnswer = "පීඩනය = 30,000 N m⁻² (30 kPa)",
      units = "Pa (Pascal) / N m⁻²",
      examTip = "මුළු පීඩනය ඇසුවහොත් දියර පීඩනයට වායුගෝල පීඩනය (100,000 Pa) එකතු කළ යුතුය."
    ),

    // Grade 11
    SciencePhysicsItem(
      id = "phy_11_01",
      grade = "11",
      unitName = "ඕම්ගේ නියමය සහ ප්‍රතිරෝධ (Ohm's Law)",
      formula = "V = IR  |  ශ්‍රේණිගත: R = R₁ + R₂  |  සමාන්තරගත: 1/R = 1/R₁ + 1/R₂",
      formulaExplanation = "V = විභව අන්තරය (Volt), I = ධාරාව (Ampere), R = ප්‍රතිරෝධය (Ohm - Ω)",
      problemText = "12 V බැටරියකට 4 Ω සහ 6 Ω ප්‍රතිරෝධක දෙකක් ශ්‍රේණිගතව සම්බන්ධ කර ඇත. 1. පරිපථයේ මුළු ප්‍රතිරෝධය 2. පරිපථය හරහා ගලන මුළු ධාරාව ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "1. ශ්‍රේණිගත මුළු ප්‍රතිරෝධය (R): R = R₁ + R₂ = 4 + 6 = 10 Ω",
        "2. ඕම්ගේ නියමයෙන් ධාරාව (I): V = IR ➔ I = V / R",
        "I = 12 V / 10 Ω = 1.2 A"
      ),
      finalAnswer = "මුළු ප්‍රතිරෝධය = 10 Ω, ධාරාව = 1.2 A",
      units = "Ω (Ohm) සහ A (Ampere)",
      examTip = "සමාන්තරගත පරිපථයක සෑම ප්‍රතිරෝධකයක් හරහාම විභව අන්තරය (V) සමාන වන අතර ශ්‍රේණිගත පරිපථයක ධාරාව (I) සමාන වේ."
    ),
    SciencePhysicsItem(
      id = "phy_11_02",
      grade = "11",
      unitName = "විද්‍යුත් ශක්තිය සහ ක්ෂමතාව (Power & Units)",
      formula = "P = VI = I²R = V²/R  |  විදුලි ඒකක = (P(W) × t(h)) / 1000",
      formulaExplanation = "P = ක්ෂමතාව (Watt), E = ශක්තිය (Joule / kWh), 1 Unit = 1 kWh (කිලෝවොට් පැය)",
      problemText = "2000 W විදුලි හීටරයක් දිනකට පැය 3ක් ක්‍රියාත්මක කෙරේ. දින 30ක් සහිත මසක් සඳහා වැයවන විදුලි ඒකක (Units) ගණන සොයන්න.",
      stepByStepSolution = listOf(
        "දිනකට වැයවන කාලය = පැය 3",
        "මාසයක මුළු කාලය = 3 පැය × 30 = පැය 90",
        "විදුලි ඒකක ගණන = (P × t) / 1000",
        "Units = (2000 W × 90 h) / 1000 = 180,000 / 1000 = 180 kWh"
      ),
      finalAnswer = "වැයවන ඒකක ගණන = 180 Units",
      units = "kWh (Units)",
      examTip = "1 Unit එකක් යනු වොට් 1000ක උපකරණයක් පැයක් ක්‍රියාකිරීමේදී වැයවන ශක්තියයි (3,600,000 J)."
    ),
    SciencePhysicsItem(
      id = "phy_11_03",
      grade = "11",
      unitName = "තරංග චලිතය (Wave Mechanics)",
      formula = "v = fλ  සහ  f = 1 / T",
      formulaExplanation = "v = තරංග ප්‍රවේගය (m s⁻¹), f = සංඛ්‍යාතය (Hz), λ = තරංග ආයාමය (m), T = ආවර්ත කාලය (s)",
      problemText = "ශබ්ද ප්‍රභවයකින් නිකුත් වන තරංගයක සංඛ්‍යාතය 500 Hz වේ. වාතයේ ශබ්දයේ ප්‍රවේගය 340 m s⁻¹ නම්, එම ශබ්ද තරංගයේ තරංග ආයාමය (λ) ගණනය කරන්න.",
      stepByStepSolution = listOf(
        "දත්ත: f = 500 Hz, v = 340 m s⁻¹",
        "v = fλ සූත්‍රය ආදේශය:",
        "340 = 500 × λ",
        "λ = 340 / 500 = 0.68 m (මීටර් 0.68 හෙවත් 68 cm)"
      ),
      finalAnswer = "තරංග ආයාමය (λ) = 0.68 m",
      units = "Meter (m)",
      examTip = "සංඛ්‍යාතය (f) යනු තත්පරයකදී ලක්ෂ්‍යයක් පසුකර යන පූර්ණ තරංග ගණනයි."
    )
  )

  // 3. PRACTICALS
  val practicalItems = listOf(
    // Grade 10
    SciencePracticalItem(
      id = "prac_10_01",
      grade = "10",
      title = "ප්‍රභාසංස්ලේෂණය සඳහා ආලෝකය අත්‍යවශ්‍ය බව පෙන්වීම",
      aim = "ශාක පත්‍ර තුළ පිෂ්ඨය නිපදවීමට සූර්යාලෝකය අවශ්‍ය බව ප්‍රායෝගිකව තහවුරු කිරීම.",
      apparatus = listOf("බඳුන්ගත පැළෑටියක්", "කළු කඩදාසි / ක්ලිප්", "තාපාංක නළය", "ජල තාපකය", "එතනෝල්", "අයඩින් ද්‍රාවණය"),
      method = listOf(
        "පැළෑටිය පැය 48ක් අඳුරේ තබා පත්‍ර පිෂ්ඨයෙන් තොර කරන්න (නිෂ්පිෂ්ඨනය).",
        "එක් පත්‍රයක කොටසක් කළු කඩදාසියකින් දෙපසින්ම ආවරණය කර පැය කිහිපයක් හිරු එළියේ තබන්න.",
        "පත්‍රය නෙළා උතුරන ජලයේ විනාඩියක් තම්බා සෛල මරණයට පත්කරන්න.",
        "එතනෝල් සහිත තාපාංක නළයක බහා ජල තාපකයක රත්කර ක්ලෝරෆිල් ඉවත් කරන්න (වර්ණහරණය).",
        "පත්‍රය මද උණුසුම් ජලයෙන් සෝදා අයඩින් ද්‍රාවණය බින්දු කිහිපයක් දමන්න."
      ),
      observation = "ආලෝකය ලැබුණු කොටස තද නිල්-කළු පැහැයට හැරේ. කළු කඩදාසියෙන් ආවරණය කළ කොටස ලා දුඹුරු (අයඩින් වර්ණය) ලෙස පවතී.",
      conclusion = "ප්‍රභාසංස්ලේෂණය සිදුවී පිෂ්ඨය සෑදීමට ආලෝකය අත්‍යවශ්‍ය වේ.",
      examPrecautions = listOf(
        "එතනෝල් දැවෙනසුළු බැවින් සෘජුව දැල්ලට නොඅල්ලා ජල තාපකයක පමණක් රත්කළ යුතුය.",
        "අඳුරේ තැබීමෙන් පත්‍රයේ මුලින් තිබූ පිෂ්ඨය ශාකයේ වෙනත් කොටස්වලට සංචිත වීම සිදුවේ."
      )
    ),
    SciencePracticalItem(
      id = "prac_10_02",
      grade = "10",
      title = "සංයුක්ත අන්වීක්ෂයෙන් ළූණු සිවියක සෛල නිරීක්ෂණය",
      aim = "ශාක සෛලයක සෛල බිත්තිය, න්‍යෂ්ටිය සහ සෛල ප්ලාස්මය හඳුනාගැනීම.",
      apparatus = listOf("ළූණු ගෙඩියක්", "වීදුරු කදාව සහ ආවරණ කදාව", "අඬුව / ඉඳිකටුව", "අයඩින් හෝ මෙතිලීන් බ්ලූ ද්‍රාවණය", "සංයුක්ත අන්වීක්ෂය"),
      method = listOf(
        "ළූණු කොරපොතු පත්‍රයකින් අඬුව ආධාරයෙන් ඉතා තුනී සිවියක් ගලවා ගන්න.",
        "වීදුරු කදාව මත තැබූ ජල බින්දුවක් මත සිවිය රැළි නොවැටෙන සේ දිගහරින්න.",
        "අයඩින් බින්දුවක් යොදා ආවරණ කදාව වායු බුබුළු නොසිටින සේ අංශක 45ක කෝණයකින් තබන්න.",
        "අන්වීක්ෂයේ අඩු බල කාචයෙන් පටන්ගෙන නිරීක්ෂණය කරන්න."
      ),
      observation = "ඉඩකඩ නොමැතිව එකිනෙකට තදින් බැඳුණු ගඩොල් වැනි සෛල පේළි, පැහැදිලි සෛල බිත්ති සහ තදින් වර්ණ ගැන්වුණු ගෝලාකාර න්‍යෂ්ටි පෙනේ.",
      conclusion = "ශාක සෛල බහුඅස්‍රාකාර වන අතර සෛල බිත්තියක් හා පැහැදිලි න්‍යෂ්ටියක් දරයි.",
      examPrecautions = listOf(
        "ආවරණ කදාව තැබීමේදී වායු බුබුළු හිරවීම වැළැක්වීමට ආධාරක ඉඳිකටුවක් භාවිතා කරන්න.",
        "අතිරික්ත වර්ණකය පෙරහන් කඩදාසියකින් උරා ඉවත් කරන්න."
      )
    ),

    // Grade 11
    SciencePracticalItem(
      id = "prac_11_01",
      grade = "11",
      title = "සරල රසායනික කෝෂයක් (Voltaic Cell) සැකසීම",
      aim = "රසායනික ශක්තිය විද්‍යුත් ශක්තිය බවට පරිවර්තනය වීම පෙන්වීම.",
      apparatus = listOf("තනුක H₂SO₄ අම්ලය", "තඹ (Cu) තහඩුවක් (+ අග්‍රය)", "සින්ක් (Zn) තහඩුවක් (- අග්‍රය)", "වෝල්ට්මීටරයක් / කුඩා LED බල්බයක්", "සම්බන්ධක වයර්"),
      method = listOf(
        "වීදුරු බීකරයකට තනුක සල්ෆියුරික් අම්ලය දමන්න.",
        "පිරිසිදු කරගත් Cu සහ Zn තහඩු එකිනෙක ස්පර්ශ නොවන සේ අම්ලයේ ගිල්වන්න.",
        "සම්බන්ධක වයර් මඟින් තහඩු දෙක වෝල්ට්මීටරයට හෝ LED බල්බයට සම්බන්ධ කරන්න."
      ),
      observation = "LED බල්බය දැල්වේ. වෝල්ට්මීටරයේ 1.1 V පමණ විභව අන්තරයක් පෙන්වයි. සින්ක් තහඩුව ක්ෂය වන අතර තඹ තහඩුව මත වායු බුබුළු (H₂) පිටවේ.",
      conclusion = "ලෝහ දෙකක ඉලෙක්ට්‍රෝන විභව වෙනස නිසා බාහිර පරිපථය හරහා ධාරාව ගලා යයි.",
      examPrecautions = listOf(
        "ධ්‍රැවීකරණය වැළැක්වීමට ඔක්සිකාරකයක් (උදා: K₂Cr₂O₇) යෙදිය හැක.",
        "දේශීය ක්‍රියාව වැළැක්වීමට රසදිය ආලේපිත සින්ක් තහඩු යොදාගනී."
      )
    ),
    SciencePracticalItem(
      id = "prac_11_02",
      grade = "11",
      title = "ඔක්සිජන් (O₂) වායුව රසායනාගාරයේ පිළියෙල කිරීම",
      aim = "හයිඩ්‍රජන් පෙරොක්සයිඩ් වියෝජනයෙන් ඔක්සිජන් වායුව සාදා හඳුනාගැනීම.",
      apparatus = listOf("H₂O₂ ද්‍රාවණය", "මැංගනීස් ඩයොක්සයිඩ් (MnO₂ - උත්ප්‍රේරකය)", "කේතුක ප්ලාස්කුව", "තිරිඟු පුනීලය", "වායු සැපයුම් නළය", "ජල භාජනය සහ වායු ජාර"),
      method = listOf(
        "කේතුක ප්ලාස්කුවට කළු පැහැති MnO₂ කුඩු ස්වල්පයක් දමන්න.",
        "තිරිඟු පුනීලය හරහා හයිඩ්‍රජන් පෙරොක්සයිඩ් (H₂O₂) ද්‍රාවණය එක්කරන්න.",
        "ජලයේ යටි විස්ථාපනයෙන් නිකුත් වන වායුව වායු ජාරයකට එකතු කරගන්න."
      ),
      observation = "වේගයෙන් වායු බුබුළු පිටවේ. දිලිසෙන පුලිඟුවක් වායු ජාරයට ඇතුළු කළ විට එය දීප්තිමත්ව දැල්වේ.",
      conclusion = "2H₂O₂ ➔ 2H₂O + O₂ ප්‍රතික්‍රියාවෙන් ඔක්සිජන් වායුව නිපදවේ. ඔක්සිජන් දහනයට ආධාර කරයි.",
      examPrecautions = listOf(
        "තිරිඟු පුනීලයේ කෙළවර ද්‍රාවණය තුළ ගිලී තිබිය යුතුය (නැතහොත් වායුව පුනීලයෙන් පිටවේ).",
        "වායුව ජලයේ යටි විස්ථාපනයෙන් එකතු කරන්නේ එය ජලයේ අල්ප වශයෙන් දියවන බැවිනි."
      )
    )
  )

  // 4. BIOLOGY DIAGRAMS
  val biologyDiagrams = listOf(
    // Grade 10
    ScienceBiologyDiagramItem(
      id = "bio_10_01",
      grade = "10",
      diagramTitle = "ශාක සෛලය සහ ඉන්ද්‍රයිකා (Plant Cell)",
      systemCategory = "සෛලීය ජීව විද්‍යාව",
      overview = "ශාක සෛලයක් සෙලියුලෝස් සෛල බිත්තියකින් ආවරණය වී ඇති අතර, විශාල කේන්ද්‍රීය රික්තකයක් සහ හරිතලව දරයි.",
      labels = listOf(
        BioLabelPart("A", "සෛල බිත්තිය (Cell Wall)", "සෙලියුලෝස් වලින් සෑදී ඇත; සෛලයට නියත හැඩයක් හා ශක්තියක් ලබාදේ."),
        BioLabelPart("B", "ප්ලාස්ම පටලය (Plasma Membrane)", "අර්ධ පාරගම්‍ය වේ; ද්‍රව්‍ය සෛලයට ඇතුළුවීම හා පිටවීම පාලනය කරයි."),
        BioLabelPart("C", "න්‍යෂ්ටිය (Nucleus)", "ප්‍රවේණික ද්‍රව්‍ය (DNA) දරයි; සෛලයේ සියලු ජීවී ක්‍රියා පාලනය කරයි."),
        BioLabelPart("D", "හරිතලව (Chloroplast)", "ක්ලෝරෆිල් අඩංගුය; ප්‍රභාසංස්ලේෂණය සිදුකර ආහාර නිපදවයි."),
        BioLabelPart("E", "මයිටොකොන්ඩ්‍රියාව (Mitochondria)", "සෛලීය ශ්වසනය මඟින් ATP ශක්තිය නිපදවයි (සෛලයේ බලාගාරය)."),
        BioLabelPart("F", "මධ්‍ය රික්තකය (Central Vacuole)", "සෛල යුෂයෙන් පිරී ඇත; සෛලයේ සවිවරතාව පවත්වා ගනී.")
      ),
      examQuestions = listOf(
        "ශාක සෛලයක ඇති නමුත් සත්ත්ව සෛලයක නොමැති ඉන්ද්‍රයිකා 2ක් ලියන්න. (පිළිතුර: සෛල බිත්තිය, හරිතලව)",
        "සෛලයේ ප්‍රවේණික තොරතුරු ගබඩා කර ඇත්තේ කුමන කොටසේද? (පිළිතුර: න්‍යෂ්ටිය)"
      )
    ),
    ScienceBiologyDiagramItem(
      id = "bio_10_02",
      grade = "10",
      diagramTitle = "මානව ආහාර ජීරණ පද්ධතිය (Human Digestive System)",
      systemCategory = "මානව කායික විද්‍යාව",
      overview = "මුඛයේ සිට ගුදය දක්වා විහිදුණු අන්ත්‍ර මාර්ගය සහ අනුබද්ධ ග්‍රන්ථි (අක්මාව, අග්න්‍යාශය) වලින් සමන්විත වේ.",
      labels = listOf(
        BioLabelPart("1", "මුඛ කුහරය (Mouth)", "කෙල ඇමයිලේස් (ටයලින්) මඟින් පිෂ්ඨය මෝල්ටෝස් බවට ජීරණය අරඹයි."),
        BioLabelPart("2", "ආමාශය (Stomach)", "HCl අම්ලය සහ පෙප්සින් මඟින් ප්‍රෝටීන පොලිපෙප්ටයිඩ බවට පත්කරයි."),
        BioLabelPart("3", "අක්මාව (Liver)", "පිත නිපදවයි; ලිපිඩ තෛලෝදකරණය කර ජීරණය පහසු කරයි."),
        BioLabelPart("4", "අග්න්‍යාශය (Pancreas)", "ට්‍රිප්සින්, ඇමයිලේස් සහ ලයිපේස් අඩංගු අග්න්‍යාශයික යුෂය ස්‍රාවය කරයි."),
        BioLabelPart("5", "කුඩා අන්ත්‍රය (Small Intestine)", "ආහාර සම්පූර්ණයෙන් ජීරණය වී ක්ෂුද්‍රාංකුර මඟින් රුධිරයට අවශෝෂණය වේ."),
        BioLabelPart("6", "මහා අන්ත්‍රය (Large Intestine)", "ජලය සහ ඛනිජ ලවණ නැවත අවශෝෂණය කර මල ද්‍රව්‍ය සාදයි.")
      ),
      examQuestions = listOf(
        "ලිපිඩ තෛලෝදකරණය කරන යුෂය නිපදවන්නේ කුමන අවයවයෙන්ද? (පිළිතුර: අක්මාව)",
        "ජීරණය වූ පෝෂක අවශෝෂණයට ක්ෂුද්‍රාන්ත්‍රයේ ඇති අනුවර්තනය කුමක්ද? (පිළිතුර: ක්ෂුද්‍රාංකුර මඟින් පෘෂ්ඨික වර්ගඵලය වැඩි කිරීම)"
      )
    ),

    // Grade 11
    ScienceBiologyDiagramItem(
      id = "bio_11_01",
      grade = "11",
      diagramTitle = "මානව හෘදයේ අභ්‍යන්තර ව්‍යුහය (Human Heart)",
      systemCategory = "සංසරණ පද්ධතිය",
      overview = "කුටීර 4කින් යුත් මාංශපේශලී පොම්පයකි; ඔක්සිජනීකෘත සහ ඔක්සිජන්හීන රුධිරය මිශ්‍ර නොවී වෙන්කර තබයි.",
      labels = listOf(
        BioLabelPart("A", "දකුණු කර්ණිකාව (Right Atrium)", "මහා ශිරා මඟින් ශරීරයෙන් එන ඔක්සිජන්හීන රුධිරය ලබාගනී."),
        BioLabelPart("B", "දකුණු කෝෂිකාව (Right Ventricle)", "පුප්ඵුසීය ධමනිය හරහා පෙනහලු වෙත රුධිරය පොම්ප කරයි."),
        BioLabelPart("C", "වම් කර්ණිකාව (Left Atrium)", "පුප්ඵුසීය ශිරා මඟින් පෙනහලුවලින් එන ඔක්සිජනීකෘත රුධිරය ලබාගනී."),
        BioLabelPart("D", "වම් කෝෂිකාව (Left Ventricle)", "ඝනකම් පේශි බිත්තියක් ඇත; මහා ධමනියෙන් මුළු සිරුරටම රුධිරය පොම්ප කරයි."),
        BioLabelPart("E", "ත්‍රිකුණ කපාටය (Tricuspid Valve)", "දකුණු කර්ණිකාව හා කෝෂිකාව අතර පිහිටයි; රුධිරය ආපසු ගැලීම වළකයි."),
        BioLabelPart("F", "ද්විකුණ / මයිට්‍රල් කපාටය (Bicuspid Valve)", "වම් කර්ණිකාව හා කෝෂිකාව අතර පිහිටයි.")
      ),
      examQuestions = listOf(
        "වම් කෝෂිකා බිත්තිය දකුණු කෝෂිකා බිත්තියට වඩා ඝනකම් වීමට හේතුව කුමක්ද? (පිළිතුර: වැඩි පීඩනයකින් මුළු සිරුරටම රුධිරය පොම්ප කළ යුතු බැවින්)",
        "ශරීරයේ ඔක්සිජනීකෘත රුධිරය ගෙනියන එකම ශිරාව කුමක්ද? (පිළිතුර: පුප්ඵුසීය ශිරාව)"
      )
    ),
    ScienceBiologyDiagramItem(
      id = "bio_11_02",
      grade = "11",
      diagramTitle = "මානව නෙෆ්‍රෝනය (Nephron - වෘක්ක ඒකකය)",
      systemCategory = "බහිස්ස්‍රාවී පද්ධතිය",
      overview = "වකුගඩුවේ මූලික ව්‍යුහමය හා කෘත්‍යමය ඒකකය වන අතර අතිපෙරීම සහ වෘණාත්මක ප්‍රතිඅවශෝෂණය සිදුකරයි.",
      labels = listOf(
        BioLabelPart("1", "බෝමන් ප්‍රවාරය (Bowman's Capsule)", "කෝප්පාකාර ව්‍යුහයකි; රුධිර ප්ලාස්මාව අතිපෙරීමට ලක්කරයි."),
        BioLabelPart("2", "කේශනාලිකා ගුච්ඡය (Glomerulus)", "ඉහළ රුධිර පීඩනයක් සහිත කේශනාලිකා ජාලයකි; අතිපෙරීම ඇතිකරයි."),
        BioLabelPart("3", "සමීපස්ථ සංවලිත නාලිකාව (PCT)", "ග්ලූකෝස්, ඇමයිනෝ අම්ල සහ ජලයෙන් 80%ක් නැවත රුධිරයට අවශෝෂණය කරයි."),
        BioLabelPart("4", "හෙන්ලේ පුඩුව (Henle's Loop)", "U හැඩැති නාලිකාවයි; ජලය සහ ලවණ තුලනය පාලනය කරයි."),
        BioLabelPart("5", "දුරස්ථ සංවලිත නාලිකාව (DCT)", "හෝමෝන මඟින් (ADH, ඇල්ඩොස්ටෙරෝන්) ජලය හා ලවණ අවශෝෂණය පාලනය කරයි."),
        BioLabelPart("6", "සංග්‍රාහක නාලය (Collecting Duct)", "සාදන ලද මුත්‍ර එකතු කර වෘක්ක ශ්‍රෝණිය වෙත යවයි.")
      ),
      examQuestions = listOf(
        "සාමාන්‍ය නිරෝගී පුද්ගලයෙකුගේ මුත්‍රාවල ග්ලූකෝස් අඩංගු නොවීමට හේතුව කුමක්ද? (පිළිතුර: PCT තුළදී සියලු ග්ලූකෝස් නැවත රුධිරයට අවශෝෂණය වන බැවින්)",
        "කේශනාලිකා ගුච්ඡය තුළ ඉහළ රුධිර පීඩනයක් ඇතිවීමට ව්‍යුහමය හේතුව කුමක්ද? (පිළිතුර: අභිවාහී ධමනිකාවේ විෂ්කම්භය අපවාහී ධමනිකාවට වඩා විශාල වීම)"
      )
    )
  )

  // 5. RAPID-FIRE MCQs
  val mcqItems = listOf(
    // Grade 10
    ScienceRapidMcqItem(
      id = "mcq_10_01",
      grade = "10",
      unitName = "ජීවයේ රසායනික පදනම",
      question = "ප්‍රෝටීන සෑදීමේ මූලික තැනුම් ඒකකය වන්නේ මින් කුමක්ද?",
      options = listOf("ග්ලූකෝස්", "ඇමයිනෝ අම්ල", "මේද අම්ල", "නියුක්ලියෝටයිඩ"),
      correctIndex = 1,
      explanation = "ප්‍රෝටීන යනු ඇමයිනෝ අම්ල පෙප්ටයිඩ බන්ධන මඟින් බැඳී සෑදුණු බහුඅවයවික වේ."
    ),
    ScienceRapidMcqItem(
      id = "mcq_10_02",
      grade = "10",
      unitName = "පදාර්ථයේ ව්‍යුහය",
      question = "පරමාණුවක න්‍යෂ්ටිය තුළ අඩංගු උපපරමාණුක අංශු වන්නේ,",
      options = listOf("ප්‍රෝටෝන සහ ඉලෙක්ට්‍රෝන", "ඉලෙක්ට්‍රෝන සහ නියුට්‍රෝන", "ප්‍රෝටෝන සහ නියුට්‍රෝන", "ප්‍රෝටෝන පමණි"),
      correctIndex = 2,
      explanation = "න්‍යෂ්ටිය සෑදී ඇත්තේ ධන ආරෝපිත ප්‍රෝටෝන සහ ආරෝපණයක් නැති නියුට්‍රෝන වලිනි (න්‍යෂ්ටික). ඉලෙක්ට්‍රෝන න්‍යෂ්ටිය වටා ශක්ති මට්ටම්වල භ්‍රමණය වේ."
    ),
    ScienceRapidMcqItem(
      id = "mcq_10_03",
      grade = "10",
      unitName = "චලිතය",
      question = "ප්‍රවේගය - කාලය ප්‍රස්තාරයක බෑවුමෙන් (අනුක්‍රමණයෙන්) නිරූපණය වන්නේ කුමක්ද?",
      options = listOf("විස්ථාපනය", "ත්වරණය", "ගම්‍යතාව", "බලය"),
      correctIndex = 1,
      explanation = "ප්‍රවේගය-කාලය ප්‍රස්තාරයක අනුක්‍රමණය = ප්‍රවේග වෙනස / කාලය = ත්වරණය වේ. ප්‍රස්තාරය යටතේ වර්ගඵලයෙන් විස්ථාපනය ලැබේ."
    ),

    // Grade 11
    ScienceRapidMcqItem(
      id = "mcq_11_01",
      grade = "11",
      unitName = "ප්‍රවේණිය",
      question = "විෂමයුග්මක උස (Tt) මෝටර් ශාක දෙකක් අතර ස්වපරාගනයෙන් ලැබෙන පරම්පරාවේ ප්‍රවේණිදර්ශ අනුපාතය කුමක්ද?",
      options = listOf("3 : 1", "1 : 2 : 1", "1 : 1", "9 : 3 : 3 : 1"),
      correctIndex = 1,
      explanation = "Tt × Tt මුහුම් කළ විට ලැබෙන ප්‍රවේණිදර්ශ වන්නේ 1 TT : 2 Tt : 1 tt වේ (1:2:1). රූපානුදර්ශ අනුපාතය 3 උස : 1 මිටි වේ."
    ),
    ScienceRapidMcqItem(
      id = "mcq_11_02",
      grade = "11",
      unitName = "ධාරා විද්‍යුතය",
      question = "සමාන 6 Ω ප්‍රතිරෝධක තුනක් සමාන්තරගතව සම්බන්ධ කළ විට ලැබෙන සමක ප්‍රතිරෝධය කොපමණද?",
      options = listOf("18 Ω", "6 Ω", "2 Ω", "0.5 Ω"),
      correctIndex = 2,
      explanation = "සමාන්තරගත සූත්‍රය: 1/R = 1/6 + 1/6 + 1/6 = 3/6 = 1/2. එබැවින් සමක ප්‍රතිරෝධය R = 2 Ω වේ."
    ),
    ScienceRapidMcqItem(
      id = "mcq_11_03",
      grade = "11",
      unitName = "ලෝහ නිස්සාරණය",
      question = "යකඩ නිස්සාරණයේදී ධමන ඌෂ්මකයට හුණුගල් (CaCO₃) එකතු කරන්නේ කුමන කාර්යය සඳහාද?",
      options = listOf("යකඩ ඔක්සිහරණය කිරීමට", "තාපය නිපදවීමට", "සිලිකා අපද්‍රව්‍ය ලෝහ බොර ලෙස ඉවත් කිරීමට", "ඌෂ්මකය සිසිල් කිරීමට"),
      correctIndex = 2,
      explanation = "CaCO₃ වියෝජනයෙන් ලැබෙන CaO, සිලිකා (SiO₂) සමඟ ප්‍රතික්‍රියා කර CaSiO₃ (කැල්සියම් සිලිකේට් - ලෝහ බොර) ලෙස උඩින් පා වී ඉවත් වේ."
    )
  )
}

// =============================================================
// COMPACT & EXPANDABLE CARD VIEWS FOR SCIENCE SUBJECT PAGE
// =============================================================

@Composable
fun ScienceGrade10And11MasterHub(
  currentGrade: String = "10",
  onOpenFullReader: (String) -> Unit = {}
) {
  var selectedGrade by remember {
    mutableStateOf(if (currentGrade == "11") ScienceHubGradeFilter.GRADE_11 else ScienceHubGradeFilter.GRADE_10)
  }
  var selectedModule by remember { mutableStateOf<ScienceModuleType?>(null) }

  // Main Card Container with rich gradients
  Card(
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
    border = BorderStroke(1.2.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("science_grade_10_11_master_hub")
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      // Header Row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text("🔬", fontSize = 18.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "10 & 11 විද්‍යාව විෂය නිර්දේශ Master Hub",
              color = Color.White,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "සමීකරණ • භෞතික සූත්‍ර • ප්‍රායෝගික • රූ සටහන් • MCQs",
              color = Color(0xFFA7F3D0),
              fontSize = 9.5.sp
            )
          }
        }

        Surface(
          color = Color(0xFF10B981),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = "100% නිවැරදි",
            color = Color.White,
            fontSize = 8.5.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Grade Toggle Pills: 10 ශ්‍රේණිය vs 11 ශ්‍රේණිය
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(10.dp))
          .background(Color(0xFF022C22))
          .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        ScienceHubGradeFilter.values().forEach { g ->
          val isSelected = selectedGrade == g
          Surface(
            onClick = {
              selectedGrade = g
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) Color(0xFF10B981) else Color.Transparent,
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(vertical = 5.dp),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (g == ScienceHubGradeFilter.GRADE_10) "📘 10 ශ්‍රේණිය" else "📙 11 ශ්‍රේණිය (O/L)",
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color(0xFF6EE7B7)
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Module Selector Strip (Compact Horizontal Grid)
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        items(ScienceModuleType.values()) { mod ->
          val isSelected = selectedModule == mod
          Surface(
            onClick = {
              selectedModule = if (isSelected) null else mod
            },
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) mod.badgeColor else Color(0xFF065F46),
            border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF047857))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
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

      // Content Display Area depending on Selected Module
      val activeGradeStr = selectedGrade.gradeStr
      when (selectedModule) {
        ScienceModuleType.CHEMISTRY -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.chemistryItems.filter { it.grade == activeGradeStr }
          }
          ScienceChemistrySubSection(items = items, grade = activeGradeStr)
        }
        ScienceModuleType.PHYSICS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.physicsItems.filter { it.grade == activeGradeStr }
          }
          SciencePhysicsSubSection(items = items, grade = activeGradeStr)
        }
        ScienceModuleType.PRACTICALS -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.practicalItems.filter { it.grade == activeGradeStr }
          }
          SciencePracticalsSubSection(items = items, grade = activeGradeStr)
        }
        ScienceModuleType.BIOLOGY -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.biologyDiagrams.filter { it.grade == activeGradeStr }
          }
          ScienceBiologySubSection(items = items, grade = activeGradeStr)
        }
        ScienceModuleType.MCQ_CHALLENGE -> {
          val items = remember(activeGradeStr) {
            ScienceGrade1011SyllabusRepository.mcqItems.filter { it.grade == activeGradeStr }
          }
          ScienceMcqChallengeSubSection(items = items, grade = activeGradeStr)
        }
        null -> {
          // Default Overview Cards when nothing is expanded
          ScienceQuickOverviewRow(
            grade = activeGradeStr,
            onSelectModule = { selectedModule = it }
          )
        }
      }
    }
  }
}

// -------------------------------------------------------------
// SUB-SECTIONS IMPLEMENTATIONS
// -------------------------------------------------------------

@Composable
private fun ScienceQuickOverviewRow(
  grade: String,
  onSelectModule: (ScienceModuleType) -> Unit
) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🧪",
        title = "රසායනික තුලනය",
        subtitle = "$grade ශ්‍රේණිය සමීකරණ",
        color = Color(0xFF0369A1),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.CHEMISTRY) }
      )
      ScienceFeatureButton(
        icon = "⚡",
        title = "භෞතික සූත්‍ර",
        subtitle = "ගණිත ගැටලු විසඳුම්",
        color = Color(0xFFB45309),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.PHYSICS) }
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      ScienceFeatureButton(
        icon = "🔬",
        title = "ප්‍රායෝගික පරීක්ෂණ",
        subtitle = "නිරීක්ෂණ & නිගමන",
        color = Color(0xFF047857),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.PRACTICALS) }
      )
      ScienceFeatureButton(
        icon = "🫀",
        title = "ජීව විද්‍යා සටහන්",
        subtitle = "කොටස් නම් කිරීම",
        color = Color(0xFFBE123C),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.BIOLOGY) }
      )
      ScienceFeatureButton(
        icon = "🎯",
        title = "MCQs",
        subtitle = "Rapid-Fire",
        color = Color(0xFF6D28D9),
        modifier = Modifier.weight(1f),
        onClick = { onSelectModule(ScienceModuleType.MCQ_CHALLENGE) }
      )
    }
  }
}

@Composable
private fun ScienceFeatureButton(
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
    color = color.copy(alpha = 0.25f),
    border = BorderStroke(1.dp, color.copy(alpha = 0.6f)),
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = title,
          fontSize = 10.5.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      Text(
        text = subtitle,
        fontSize = 8.5.sp,
        color = Color(0xFFA7F3D0),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

// 1. CHEMISTRY DETAILS VIEW
@Composable
private fun ScienceChemistrySubSection(
  items: List<ScienceChemItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF0F172A))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "🧪 $grade ශ්‍රේණිය - රසායනික සූත්‍ර සහ තුලිත සමීකරණ",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF38BDF8)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xFF334155)),
        modifier = Modifier.fillMaxWidth().clickable { isExpanded = !isExpanded }
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
                text = item.category,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "තුලිත සමීකරණය: ${item.balancedEquation}",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color(0xFF4ADE80)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "ප්‍රතික්‍රියක හා ඵල: ${item.reactantsSinhala}",
              fontSize = 9.5.sp,
              color = Color(0xFFCBD5E1)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "තුලනය කරන පියවර: ${item.explanation}",
              fontSize = 9.5.sp,
              color = Color(0xFFFDE047)
            )
            Spacer(modifier = Modifier.height(4.dp))
            item.keyPoints.forEach { pt ->
              Text("• $pt", fontSize = 9.sp, color = Color(0xFF94A3B8))
            }
          } else {
            Text(
              text = "විස්තර සහ තුලනය කරන පියවර බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.5.sp,
              color = Color(0xFF64748B)
            )
          }
        }
      }
    }
  }
}

// 2. PHYSICS DETAILS VIEW
@Composable
private fun SciencePhysicsSubSection(
  items: List<SciencePhysicsItem>,
  grade: String
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF18181B))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "⚡ $grade ශ්‍රේණිය - භෞතික විද්‍යා සූත්‍ර සහ පියවරෙන් පියවර ගණනය කිරීම්",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFFFBBF24)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF27272A),
        border = BorderStroke(1.dp, Color(0xFF3F3F46)),
        modifier = Modifier.fillMaxWidth().clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(
            text = item.unitName,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(2.dp))
          Surface(
            shape = RoundedCornerShape(4.dp),
            color = Color(0xFFB45309).copy(alpha = 0.3f),
            border = BorderStroke(0.8.dp, Color(0xFFF59E0B))
          ) {
            Text(
              text = item.formula,
              fontSize = 10.5.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Monospace,
              color = Color(0xFFFDE047),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }

          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "ප්‍රශ්නය: ${item.problemText}",
            fontSize = 9.5.sp,
            color = Color(0xFFE4E4E7)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF09090B),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(6.dp)) {
                Text("පියවරෙන් පියවර විසඳුම:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                item.stepByStepSolution.forEach { step ->
                  Text("• $step", fontSize = 9.sp, color = Color(0xFFCBD5E1))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("අවසාන පිළිතුර: ${item.finalAnswer}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("💡 විභාග ඉඟිය: ${item.examTip}", fontSize = 8.5.sp, color = Color(0xFFF472B6))
          } else {
            Text(
              text = "පියවරෙන් පියවර ගණනය කිරීම බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.5.sp,
              color = Color(0xFF71717A)
            )
          }
        }
      }
    }
  }
}

// 3. PRACTICALS DETAILS VIEW
@Composable
private fun SciencePracticalsSubSection(
  items: List<SciencePracticalItem>,
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
      text = "🔬 $grade ශ්‍රේණිය - O/L ප්‍රායෝගික පරීක්ෂණ, නිරීක්ෂණ සහ නිගමන",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFF6EE7B7)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF047857),
        border = BorderStroke(1.dp, Color(0xFF059669)),
        modifier = Modifier.fillMaxWidth().clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Text(
            text = item.title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = "අරමුණ: ${item.aim}",
            fontSize = 9.5.sp,
            color = Color(0xFFA7F3D0)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "නිරීක්ෂණය: ${item.observation}",
              fontSize = 9.5.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFFFDE047)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "නිගමනය: ${item.conclusion}",
              fontSize = 9.5.sp,
              color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("ප්‍රවේශම් විය යුතු කරුණු:", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
            item.examPrecautions.forEach { prec ->
              Text("• $prec", fontSize = 8.5.sp, color = Color(0xFFFEE2E2))
            }
          } else {
            Text(
              text = "නිරීක්ෂණ, නිගමන සහ ප්‍රවේශම් විය යුතු කරුණු බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.5.sp,
              color = Color(0xFF6EE7B7).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// 4. BIOLOGY DETAILS VIEW
@Composable
private fun ScienceBiologySubSection(
  items: List<ScienceBiologyDiagramItem>,
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
      text = "🫀 $grade ශ්‍රේණිය - ජීව විද්‍යා රූප සටහන් සහ කොටස් නම් කිරීම",
      fontSize = 11.5.sp,
      fontWeight = FontWeight.Bold,
      color = Color(0xFFFDA4AF)
    )

    items.forEach { item ->
      var isExpanded by remember { mutableStateOf(false) }
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF881337),
        border = BorderStroke(1.dp, Color(0xFF9F1239)),
        modifier = Modifier.fillMaxWidth().clickable { isExpanded = !isExpanded }
      ) {
        Column(modifier = Modifier.padding(8.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = item.diagramTitle,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Surface(
              shape = RoundedCornerShape(4.dp),
              color = Color(0xFFBE123C)
            ) {
              Text(
                text = item.systemCategory,
                fontSize = 8.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = item.overview,
            fontSize = 9.5.sp,
            color = Color(0xFFFECDD3)
          )

          if (isExpanded) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
              shape = RoundedCornerShape(6.dp),
              color = Color(0xFF4C0519),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(6.dp)) {
                Text("නම් කරන ලද කොටස් සහ කෘත්‍යයන්:", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
                item.labels.forEach { label ->
                  Text(
                    text = "${label.labelNumber}. ${label.partName}: ${label.function}",
                    fontSize = 8.5.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 1.dp)
                  )
                }
              }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("විභාග ප්‍රශ්න සහ පිළිතුරු:", fontSize = 8.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
            item.examQuestions.forEach { q ->
              Text("• $q", fontSize = 8.5.sp, color = Color(0xFFE0F2FE))
            }
          } else {
            Text(
              text = "කොටස් නම් කිරීම සහ කෘත්‍යයන් බැලීමට ක්ලික් කරන්න ▾",
              fontSize = 8.5.sp,
              color = Color(0xFFFDA4AF).copy(alpha = 0.8f)
            )
          }
        }
      }
    }
  }
}

// 5. RAPID-FIRE MCQ CHALLENGE VIEW
@Composable
private fun ScienceMcqChallengeSubSection(
  items: List<ScienceRapidMcqItem>,
  grade: String
) {
  var currentIndex by remember { mutableIntStateOf(0) }
  var selectedOption by remember { mutableStateOf<Int?>(null) }
  var isSubmitted by remember { mutableStateOf(false) }

  val currentItem = items.getOrNull(currentIndex) ?: return

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(0xFF2E1065))
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "🎯 $grade ශ්‍රේණිය - Rapid-Fire MCQ (${currentIndex + 1}/${items.size})",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFC4B5FD)
      )
      Text(
        text = currentItem.unitName,
        fontSize = 9.sp,
        color = Color(0xFFA78BFA)
      )
    }

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
        isChosen -> Color(0xFF7C3AED)
        else -> Color(0xFF4C1D95)
      }

      Surface(
        onClick = {
          if (!isSubmitted) selectedOption = optIndex
        },
        shape = RoundedCornerShape(6.dp),
        color = optionBg,
        border = BorderStroke(1.dp, if (isChosen) Color.White else Color(0xFF5B21B6)),
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

    // Action buttons & Explanation
    if (!isSubmitted) {
      Button(
        onClick = {
          if (selectedOption != null) isSubmitted = true
        },
        enabled = selectedOption != null,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.align(Alignment.End),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
      ) {
        Text("පිළිතුර තහවුරු කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
      }
    } else {
      Surface(
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFF1E1B4B),
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
            text = "විවරණය: ${currentItem.explanation}",
            fontSize = 9.sp,
            color = Color(0xFFDDD6FE)
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
          colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9333EA)),
          shape = RoundedCornerShape(6.dp),
          modifier = Modifier.align(Alignment.End),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        ) {
          Text("මීළඟ ප්‍රශ්නය ➔", fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}
