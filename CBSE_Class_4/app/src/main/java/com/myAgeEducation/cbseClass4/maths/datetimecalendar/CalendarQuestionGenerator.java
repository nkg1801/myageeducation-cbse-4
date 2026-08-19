package com.myAgeEducation.cbseClass4.maths.datetimecalendar;


import static com.myAgeEducation.cbseClass4.maths.datetimecalendar.QuestionTemplate.DAYS_IN_MONTH_TEMPLATE;
import static com.myAgeEducation.cbseClass4.maths.datetimecalendar.QuestionTemplate.MONTH_TYPE_TEMPLATES;
import static com.myAgeEducation.cbseClass4.maths.datetimecalendar.QuestionTemplate.TEMPLATES;
import static com.myAgeEducation.cbseClass4.maths.datetimecalendar.QuestionTemplate.YEAR_TEMPLATE;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CalendarQuestionGenerator {
    private static final Random RANDOM = new Random();
    private static final int MIN_YEAR = 2020;
    private static final int MAX_YEAR = 2030;

    public enum RelativeDayType {
        CURRENT,
        NEXT,
        PREVIOUS
    }

    public static Question generateQuestion()
    {
        int year = MIN_YEAR + RANDOM.nextInt(MAX_YEAR - MIN_YEAR + 1);
        Month month = Month.of(RANDOM.nextInt(12) + 1);
        Question question = new Question();
        QuestionTemplate.CalendarQuestionType type =
                QuestionTemplate.CalendarQuestionType.values()[RANDOM.nextInt(QuestionTemplate.CalendarQuestionType.values().length)];

        switch (type) {

            case WEEKDAY_COUNT:
                return generateWeekdayCountQuestion(year, month);

            case MONTH_NAME:
                return generateMonthQuestion(year, month);

            case YEAR:
                return generateYearQuestion(year, month);

            case DAYS_IN_MONTH:
                return generateDaysInMonthQuestion(year, month);

            case FIRST_DAY:
                return generateFirstDayOfMonthQuestion(year, month);

            case LAST_DAY:
                return generateLastDayOfMonthQuestion(year, month);

            case DAY_OF_DATE:
                return generateRelativeDayQuestion(year, month, RelativeDayType.CURRENT);

            case NEXT_DAY:
                return generateRelativeDayQuestion(year, month, RelativeDayType.NEXT);

            case PREVIOUS_DAY:
                return generateRelativeDayQuestion(year, month, RelativeDayType.PREVIOUS);
        }
        return question;
    }

    private static Question generateWeekdayCountQuestion(int year, Month month)
    {
        DayOfWeek weekday = DayOfWeek.of(RANDOM.nextInt(7) + 1);
        YearMonth ym = YearMonth.of(year, month);
        int count = getWeekdayCount(ym, weekday);
        List<String> options = new ArrayList<>();
        options.add(String.valueOf(count));

        if (count == 4) {
            options.add("5");
        }
        else {
            options.add("4");
        }

        options.add("3");
        options.add("6");

        Collections.shuffle(options, RANDOM);
        Question questionObj = new Question();
        QuestionTemplate template = TEMPLATES.get(RANDOM.nextInt(TEMPLATES.size()));
        questionObj.setQuestion(template.format(weekday, month, year));

        questionObj.setAnswer(String.valueOf(count));
        OptionUtils.setQuestionOptions(questionObj, options);
        questionObj.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        return questionObj;
    }

    private static Question generateMonthQuestion(int year, Month month) {

        List<String> options = new ArrayList<>();
        options.add(month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        while (options.size() < 4) {

            Month m = Month.of(RANDOM.nextInt(12) + 1);
            String name = m.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            if (!options.contains(name)) {
                options.add(name);
            }
        }

        Collections.shuffle(options, RANDOM);
        Question question = new Question();
        QuestionTemplate template = MONTH_TYPE_TEMPLATES.get(RANDOM.nextInt(MONTH_TYPE_TEMPLATES.size()));
        DayOfWeek weekday = DayOfWeek.of(RANDOM.nextInt(7) + 1);
        question.setQuestion(template.format(weekday, month, year));
        question.setAnswer(month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        OptionUtils.setQuestionOptions(question, options);
        question.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        return question;
    }

    private static Question generateYearQuestion(int year, Month month) {

        List<String> options = new ArrayList<>();
        options.add(String.valueOf(year));

        while (options.size() < 4) {

            int y = 2020 + RANDOM.nextInt(11);
            String value = String.valueOf(y);

            if (!options.contains(value)) {
                options.add(value);
            }
        }

        Collections.shuffle(options, RANDOM);
        String selectedQuestion;
        int variant = RANDOM.nextInt(YEAR_TEMPLATE.length);
        selectedQuestion = YEAR_TEMPLATE[variant];
        Question q = new Question();
        q.setQuestion(selectedQuestion);
        q.setAnswer(String.valueOf(year));
        OptionUtils.setQuestionOptions(q, options);
        q.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        return q;
    }

    private static Question generateDaysInMonthQuestion(int year, Month month) {

        YearMonth yearMonth = YearMonth.of(year, month);
        int days = yearMonth.lengthOfMonth();
        String selectedQuestion;

        int variant = RANDOM.nextInt(DAYS_IN_MONTH_TEMPLATE.length);

        if (variant == 0) {
            selectedQuestion = String.format(
                    DAYS_IN_MONTH_TEMPLATE[variant],
                    month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                    year);
        } else {
            selectedQuestion = DAYS_IN_MONTH_TEMPLATE[variant];
        }

        List<String> options = new ArrayList<>();
        options.add(String.valueOf(days));

        // Generate plausible distractors
        if (days == 28) {
            options.add("29");
            options.add("30");
            options.add("31");
        }
        else if (days == 29) {
            options.add("28");
            options.add("30");
            options.add("31");
        }
        else if (days == 30) {
            options.add("28");
            options.add("29");
            options.add("31");
        }
        else { //31
            options.add("28");
            options.add("29");
            options.add("30");
        }

        Collections.shuffle(options, RANDOM);
        Question q = new Question();
        q.setQuestion(selectedQuestion);
        q.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        q.setAnswer(String.valueOf(days));
        OptionUtils.setQuestionOptions(q, options);
        return q;
    }

    private static Question generateFirstDayOfMonthQuestion(int year, Month month)
    {
        YearMonth ym = YearMonth.of(year, month);
        DayOfWeek answer = ym.atDay(1).getDayOfWeek();

        String[] FIRST_DAY_QUESTIONS = {
                "Which day does %s %d start on?",
                "Which day is the first day of the given month?",
                "Look at the calendar below. Which day comes first in the month?",
                "The first day of %s %d is:",
                "Observe the calendar. Which weekday is the 1st of the month?"
        };

        String questionText;
        int variant = RANDOM.nextInt(FIRST_DAY_QUESTIONS.length);

        switch (variant) {
            case 0:
            case 3:
                questionText = String.format(
                        FIRST_DAY_QUESTIONS[variant],
                        month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                        year);
                break;

            default:
                questionText = FIRST_DAY_QUESTIONS[variant];
                break;
        }

        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, generateDayOptions(answer));
        question.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        String answerText = answer.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        question.setAnswer(answerText);
        return question;
    }

    private static Question generateLastDayOfMonthQuestion(int year, Month month)
    {
        YearMonth ym = YearMonth.of(year, month);
        DayOfWeek answer = ym.atEndOfMonth().getDayOfWeek();

        String[] questionVariants = {
                "Which day does %s %d end on?",
                "Which day is the last day of the given month?",
                "Look at the calendar below. Which day comes last in the month?",
                "The last day of %s %d is:",
                "Observe the calendar. Which weekday is the last day of the month?"
        };

        int variant = RANDOM.nextInt(questionVariants.length);
        String questionText;

        switch (variant)
        {
            case 0:
            case 3:
                questionText = String.format(
                        questionVariants[variant],
                        month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                        year);
                break;

            default:
                questionText = questionVariants[variant];
        }

        String answerText = answer.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, generateDayOptions(answer));
        question.setAnswer(answerText);
        question.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        return question;
    }

    private static Question generateRelativeDayQuestion(int year, Month month, RelativeDayType type)
    {
        YearMonth ym = YearMonth.of(year, month);
        int date = RANDOM.nextInt(ym.lengthOfMonth()) + 1;
        LocalDate localDate = ym.atDay(date);
        DayOfWeek answer;
        String[] questionVariants;

        switch (type)
        {
            case NEXT:
                answer = localDate.getDayOfWeek().plus(1);

                questionVariants = new String[] {
                        "Which day comes after %d %s %d?",
                        "The next day after %d %s %d is:",
                        "What day comes after %d %s %d?",
                        "Look at the calendar below. Which day comes after %d?",
                        "Observe the calendar. What day comes after the %dth?"
                };

                break;

            case PREVIOUS:
                answer = localDate.getDayOfWeek().minus(1);

                questionVariants = new String[] {
                        "Which day comes before %d %s %d?",
                        "The previous day before %d %s %d is:",
                        "What day comes before %d %s %d?",
                        "Look at the calendar below. Which day comes before %d?",
                        "Observe the calendar. What day comes before the %dth?"
                };
                break;

            default:
                answer = localDate.getDayOfWeek();
                questionVariants = new String[] {
                        "On which day does %d %s %d fall?",
                        "What day is %d %s %d?",
                        "Which day of the week is %d %s %d?",
                        "Look at the calendar below. Which day is %d?",
                        "Observe the calendar. %d falls on which day?"
                };
                break;
        }

        int variant = RANDOM.nextInt(questionVariants.length);
        String questionText;

        switch (variant)
        {
            case 0:
            case 1:
            case 2:
                questionText = String.format(
                        questionVariants[variant],
                        date,
                        month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                        year);
                break;

            default:
                questionText = String.format(questionVariants[variant], date);
                break;
        }

        String answerText = answer.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, generateDayOptions(answer));
        question.setAnswer(answerText);
        question.setImage("use_calendar_generator_code;" + month.getValue() + "_" + year);
        return question;
    }

    private static int getWeekdayCount(YearMonth yearMonth, DayOfWeek weekday) {

        int count = 0;
        for (int d = 1; d <= yearMonth.lengthOfMonth(); d++) {

            if (yearMonth.atDay(d).getDayOfWeek() == weekday) {
                count++;
            }
        }
        return count;
    }

    private static List<String> generateDayOptions(DayOfWeek answer) {

        List<String> days = Arrays.asList(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday");

        Collections.shuffle(days, RANDOM);
        List<String> options = new ArrayList<>();
        options.add(answer.getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        for (String day : days) {

            if (!day.equals(options.get(0))) {
                options.add(day);

                if (options.size() == 4)
                    break;
            }
        }

        Collections.shuffle(options, RANDOM);
        return options;
    }
}
