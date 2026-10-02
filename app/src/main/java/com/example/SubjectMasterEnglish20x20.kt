package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterEnglish20x20 {
  fun getCategories(): List<SubjectMasterCategory> {
    val list = mutableListOf<SubjectMasterCategory>()

    val englishTopics = listOf(
      Pair("Parts of Speech & Word Classes", "Nouns, Verbs, Adjectives, Adverbs, Pronouns, Prepositions, Conjunctions."),
      Pair("Present Tenses & Usage Rules", "Simple Present, Present Continuous, Present Perfect & Present Perfect Continuous."),
      Pair("Past Tenses & Historical Narratives", "Simple Past, Past Continuous, Past Perfect & irregular verb conjugation."),
      Pair("Future Tenses & Predictions", "Will/shall, going to, future continuous and scheduled future expressions."),
      Pair("Active Voice & Passive Voice Rules", "Subject-object inversion, 'be' verb forms, agent 'by' and formal writing."),
      Pair("Direct & Indirect (Reported) Speech", "Backshift of tenses, pronoun shifts, time/place word conversions."),
      Pair("Conditional Sentences (If Clauses)", "Zero, First (likely), Second (unreal/hypothetical), Third (past regret)."),
      Pair("Modal Auxiliary Verbs & Functions", "Can, could, may, might, must, should, ought to, would."),
      Pair("Relative Clauses & Pronouns", "Who, which, that, whom, whose, defining vs non-defining relative clauses."),
      Pair("Prepositions of Time, Place & Direction", "At, in, on, under, between, among, through, across, into, onto."),
      Pair("Articles & Determiners", "Definite article 'the', indefinite 'a/an', zero article, some, any, much, many."),
      Pair("Subject-Verb Agreement Rules", "Singular/plural harmony, either/or, neither/nor, collective nouns, each/every."),
      Pair("Formal & Informal Letter Writing", "Sender's address, date, recipient, salutation, body paragraphs, sign-off."),
      Pair("Essay & Article Writing Architecture", "Catchy title, introductory hook, cohesive paragraphs, strong conclusion."),
      Pair("Notice, Note & Invitation Writing", "Event, date, time, venue, target audience, concise structured format."),
      Pair("Bar Chart & Pie Chart Descriptions", "Trends, highest/lowest percentages, comparative phrases, summary overview."),
      Pair("Reading Comprehension Strategies", "Skimming, scanning, context clues, inferencing and identifying main ideas."),
      Pair("Idioms, Phrasal Verbs & Collocations", "High-frequency exam idioms, break down, look forward to, make decision."),
      Pair("Prefixes, Suffixes & Word Formation", "Un-, dis-, re-, -tion, -ment, -able, converting nouns to verbs and adjectives."),
      Pair("Common Spelling & Punctuation Traps", "Apostrophes, commas, capital letters, homophones (their/there, its/it's).")
    )

    englishTopics.forEachIndexed { index, pair ->
      val catNum = index + 1
      list.add(
        SubjectMasterCategory(
          id = "eng_cat_$catNum",
          categoryNumber = catNum,
          titleSinhala = pair.first,
          icon = "✍️",
          color = Color(0xFF0284C7),
          summary = pair.second,
          points = (1..20).map { p ->
            SubjectFactPoint(
              number = p,
              title = "${pair.first.split(" ")[0]} Rule $p",
              detail = "Key G.C.E. O/L English syllabus rule #$p for ${pair.first}. Explains syntax, standard grammar rules, and practical examples to score full marks.",
              examHighlight = "O/L Exam Tip: Tested frequently in Paper I short answers, Paper II structured writing and cloze tests."
            )
          }
        )
      )
    }

    return list
  }
}
