package com.menueditor;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CoursesDialogManager implements Serializable {

    private ArrayList<String> firstCourses;
    private ArrayList<String> secondCourses;
    private ArrayList<String> secondCourseStarches;
    private ArrayList<String> secondCourseSalads;
    private Context context;

    public CoursesDialogManager(Context cont) {

        firstCourses= new ArrayList<>();
        secondCourses= new ArrayList<>();
        secondCourseStarches= new ArrayList<>();
        secondCourseSalads= new ArrayList<>();

        context = cont;

        TinyDB tinydb = new TinyDB(context);
        firstCourses=tinydb.getListString("firstCourses");
        secondCourses=tinydb.getListString("secondCourses");
        secondCourseStarches=tinydb.getListString("secondCourseStarches");
        secondCourseSalads=tinydb.getListString("secondCourseSalads");



        if(firstCourses.size()<=0) {
            firstCourses.add("Zupa brokułowa");
            firstCourses.add("Kwaśnica");
            firstCourses.add("Zupa ogórkowa z ryżem");
            firstCourses.add("Zupa minestrone");
            firstCourses.add("Żurek z jajkiem");
            firstCourses.add("Zupa marchewkowa");
            firstCourses.add("Rosół z makaronem");
            firstCourses.add("Krupnik");
            firstCourses.add("Zupa jarzynowa");
            firstCourses.add("Zupa pomidorowa z ryżem");
            firstCourses.add("Żurek z jajkiem i kiełbasą");
            firstCourses.add("Zupa ogórkowa");
            firstCourses.add("Krem z brokułów");
            firstCourses.add("Zupa grochowa");
            firstCourses.add("Zupa chłopska");
            firstCourses.add("Zupa ryżowa");
            firstCourses.add("Zalewajka");
            firstCourses.add("Zupa pomidorowa z makaronem");
            firstCourses.add("Barszcz ukraiński");
            firstCourses.add("Zupa kalafiorowa");
            firstCourses.add("Zupa jarzynowa z kluskami lanymi");
            firstCourses.add("Kapuśniak");
            firstCourses.add("Chłodnik z ogórka");
            firstCourses.add("Zupa botwinkowa");
            firstCourses.add("Zupa zacierkowa");

            Collections.sort(firstCourses, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });
        }
        if(secondCourses.size()<=0){
            secondCourses.add("Pulpety w sosie pomidorowym");
            secondCourses.add("Karczek w kapuście");
            secondCourses.add("Schab z cebulką");
            secondCourses.add("Klops w sosie pieczarkowym");
            secondCourses.add("Gulasz z kaszą jęczmienną");
            secondCourses.add("Kotlet mielony");
            secondCourses.add("Udko pieczone");
            secondCourses.add("a'la bigos");
            secondCourses.add("Pierogi z mięsem");
            secondCourses.add("Ryba miruna");
            secondCourses.add("Kotlet schabowy");
            secondCourses.add("Schab z serem i cebulką");
            secondCourses.add("Gulasz");
            secondCourses.add("Karczek w sosie");
            secondCourses.add("Rolada");
            secondCourses.add("Schab z warzywami");
            secondCourses.add("Pulpety w sosie pieczarkowym");
            secondCourses.add("Udko drobiowe");
            secondCourses.add("Schab w majeranku");
            secondCourses.add("Klops w sosie koperkowym");
            secondCourses.add("Sztuka mięsa w sosie");
            secondCourses.add("Filet drobiowy");
            secondCourses.add("Bitki w sosie");
            secondCourses.add("Naleśniki z mięsem");
            secondCourses.add("Kopytka z gulaszem");
            secondCourses.add("Spaghetti Bolognese");
            secondCourses.add("Pieczeń rzymska");
            secondCourses.add("Roladki drobiowe");
            secondCourses.add("Pierogi z kaszą i pieczarką");
            secondCourses.add("Rolada z mięsa mielonego");
            secondCourses.add("Schab z serem i groszkiem");
            secondCourses.add("Ryba z porem");
            secondCourses.add("Zrazy wieprzowe");
            secondCourses.add("Pieczeń rzymska w sosie chrzanowym");
            secondCourses.add("Łopatka z warzywami");
            secondCourses.add("Ryba w sosie cytrynowym");
            secondCourses.add("Zapiekanka makaronowa");
            secondCourses.add("Knedle z truskawkami");
            secondCourses.add("Kotlet schabowy");
            secondCourses.add("Pierogi z kaszą gryczaną i pomidorem");

            Collections.sort(secondCourses, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });
        }
        if(secondCourseStarches.size()<=0){
            secondCourseStarches.add("ziemniaki");
            secondCourseStarches.add("babka ziemniaczana");
            secondCourseStarches.add("ryż");
            secondCourseStarches.add("kasza jęczmienna");
            secondCourseStarches.add("kasza gryczana");

            Collections.sort(secondCourseStarches, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });
        }
        if(secondCourseSalads.size()<=0){
            secondCourseSalads.add("surówka z kapusty pekińskiej");
            secondCourseSalads.add("buraki");
            secondCourseSalads.add("biała kapusta");
            secondCourseSalads.add("surówka z kapusty kiszonej");
            secondCourseSalads.add("warzywa na parze");
            secondCourseSalads.add("ogórek małosolny");
            secondCourseSalads.add("surówka z kapusty pekińskiej z marchewką");
            secondCourseSalads.add("kapusta z grochem");
            secondCourseSalads.add("surówka z białej kapusty i ogórka");
            secondCourseSalads.add("surówka z selera i jabłka");
            secondCourseSalads.add("surówka z białej kapusty i marchwi");
            secondCourseSalads.add("marchewka");
            secondCourseSalads.add("surówka z marchewki");
            secondCourseSalads.add("surówka z ogórka");
            secondCourseSalads.add("surówka z kapusty i kopru");
            secondCourseSalads.add("surówka wiosenna");
            secondCourseSalads.add("mizeria");
            secondCourseSalads.add("surówka z ogórka kiszonego");
            secondCourseSalads.add("duszona marchew");
            secondCourseSalads.add("marchewka z majonezem");
            secondCourseSalads.add("łazanki z kapustą");
            secondCourseSalads.add("kapusta zasmażana");
            Collections.sort(secondCourseSalads, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });

        }

    }

    public void saveFirstCourses(){
        TinyDB tinydb = new TinyDB(context);
        tinydb.putListString("firstCourses", firstCourses);
    }
    public void saveSecondCourses(){
        TinyDB tinydb = new TinyDB(context);
        tinydb.putListString("secondCourses", secondCourses);
    }
    public void saveSecondCourseStarches(){
        TinyDB tinydb = new TinyDB(context);
        tinydb.putListString("secondCourseStarches", secondCourseStarches);
    }
    public void saveSecondCourseSalads(){
        TinyDB tinydb = new TinyDB(context);
        tinydb.putListString("secondCourseSalads", secondCourseSalads);
    }

    public void showFirstCourseDialog(final Context context, final TextView fcTextView){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pierwsze danie:");

        builder.setItems(firstCourses.toArray(new CharSequence[firstCourses.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                fcTextView.setText(firstCourses.get(which));

            }
        });

        builder.setPositiveButton("Dodaj nowe", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Podaj nowe I danie:");
                final EditText input = new EditText(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firstCourses.add(input.getText().toString());
                        Collections.sort(firstCourses, new Comparator<String>() {
                            @Override
                            public int compare(String s1, String s2) {
                                return s1.compareToIgnoreCase(s2);
                            }
                        });
                        saveFirstCourses();
                        fcTextView.setText(input.getText().toString());

                    }
                });

                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        builder.setNeutralButton("Edytuj listę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Wybierz dania do usunięcia:");

                final ArrayList selectedItems=new ArrayList();

                builder.setMultiChoiceItems(firstCourses.toArray(new CharSequence[firstCourses.size()]), null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedItems.add(which);
                        } else if (selectedItems.contains(which)) {
                            selectedItems.remove(Integer.valueOf(which));
                        }
                    }
                });

                builder.setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Collections.sort(selectedItems, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer s1, Integer s2) {
                                return s1.compareTo(s2);
                            }
                        });
                        for(int i=0;i<selectedItems.size();++i){
                            int index = (int)selectedItems.get(i)-i;
                            firstCourses.remove(index);

                        }
                        saveFirstCourses();
                    }
                });
                builder.setNegativeButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }


    public void showSecondCourseDialog(final Context context, final TextView scTextView,final StringBuilder[] textResult){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Danie główne:");

        builder.setItems(secondCourses.toArray(new CharSequence[secondCourses.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //scTextView.setText(secondCourses.get(which));
                if(textResult[0]==null){
                    textResult[0] = new StringBuilder();
                }
                if(textResult[0]!=null){
                    textResult[0].setLength(0);
                }
                textResult[0].append(secondCourses.get(which));
                StringBuilder secondCourseText = new StringBuilder();
                if(textResult[0].toString().trim().length()>=1){
                    secondCourseText.append(textResult[0].toString());
                }
                if(textResult[1]!=null&&textResult[1].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[1].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[1].toString());
                }
                if(textResult[2]!=null&&textResult[2].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[2].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[2].toString());
                }
                scTextView.setText(secondCourseText.toString());


            }
        });

        builder.setPositiveButton("Dodaj nowe", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Podaj nowe danie główne:");
                final EditText input = new EditText(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        secondCourses.add(input.getText().toString());
                        Collections.sort(secondCourses, new Comparator<String>() {
                            @Override
                            public int compare(String s1, String s2) {
                                return s1.compareToIgnoreCase(s2);
                            }
                        });
                        //scTextView.setText(input.getText().toString());
                        if(textResult[0]==null){
                            textResult[0] = new StringBuilder();
                        }
                        if(textResult[0]!=null){
                            textResult[0].setLength(0);
                        }
                        if(textResult[0]!=null)
                        textResult[0].setLength(0);
                        textResult[0].append(input.getText().toString());
                        StringBuilder secondCourseText = new StringBuilder();
                        if(textResult[0].toString().trim().length()>=1){
                            secondCourseText.append(textResult[0].toString());
                        }
                        if(textResult[1]!=null&&textResult[1].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[1].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[1].toString());
                        }
                        if(textResult[2]!=null&&textResult[2].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[2].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[2].toString());
                        }
                        saveSecondCourses();
                        scTextView.setText(secondCourseText.toString());

                    }
                });

                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        builder.setNeutralButton("Edytuj listę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Wybierz dania do usunięcia:");

                final ArrayList selectedItems=new ArrayList();

                builder.setMultiChoiceItems(secondCourses.toArray(new CharSequence[secondCourses.size()]), null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedItems.add(which);

                        } else if (selectedItems.contains(which)) {
                            selectedItems.remove(Integer.valueOf(which));

                        }
                    }
                });

                builder.setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Collections.sort(selectedItems, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer s1, Integer s2) {
                                return s1.compareTo(s2);
                            }
                        });
                        for(int i=0;i<selectedItems.size();++i){
                            int index = (int)selectedItems.get(i)-i;
                            secondCourses.remove(index);
                        }
                        saveSecondCourses();
                    }
                });
                builder.setNegativeButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    public void showSecondCourseStarchesDialog(final Context context, final TextView scTextView,final StringBuilder[] textResult){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Dodatek:");

        builder.setItems(secondCourseStarches.toArray(new CharSequence[secondCourseStarches.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //scTextView.setText(secondCourseStarches.get(which));
                if(textResult[1]==null){
                    textResult[1] = new StringBuilder();
                }
                if(textResult[1]!=null){
                    textResult[1].setLength(0);
                }
                textResult[1].append(secondCourseStarches.get(which));
                StringBuilder secondCourseText = new StringBuilder();
                if(textResult[0]!=null&&textResult[0].toString().trim().length()>=1){
                    secondCourseText.append(textResult[0].toString());
                }
                if(textResult[1].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[1].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[1].toString());
                }
                if(textResult[2]!=null&&textResult[2].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[2].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[2].toString());
                }
                scTextView.setText(secondCourseText.toString());
            }
        });

        builder.setPositiveButton("Dodaj nowy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Podaj nowy dodatek:");
                final EditText input = new EditText(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        secondCourseStarches.add(input.getText().toString());
                        Collections.sort(secondCourseStarches, new Comparator<String>() {
                            @Override
                            public int compare(String s1, String s2) {
                                return s1.compareToIgnoreCase(s2);
                            }
                        });
                        //scTextView.setText(input.getText().toString());
                        if(textResult[1]==null){
                            textResult[1] = new StringBuilder();
                        }
                        if(textResult[1]!=null){
                            textResult[1].setLength(0);
                        }
                        textResult[1].append(input.getText().toString());
                        StringBuilder secondCourseText = new StringBuilder();
                        if(textResult[0]!=null&&textResult[0].toString().trim().length()>=1){
                            secondCourseText.append(textResult[0].toString());
                        }
                        if(textResult[1].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[1].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[1].toString());
                        }
                        if(textResult[2]!=null&&textResult[2].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[2].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[2].toString());
                        }
                        saveSecondCourseStarches();
                        scTextView.setText(secondCourseText.toString());

                    }
                });

                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        builder.setNeutralButton("Edytuj listę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Wybierz dodatki do usunięcia:");

                final ArrayList selectedItems=new ArrayList();

                builder.setMultiChoiceItems(secondCourseStarches.toArray(new CharSequence[secondCourseStarches.size()]), null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedItems.add(which);

                        } else if (selectedItems.contains(which)) {
                            selectedItems.remove(Integer.valueOf(which));

                        }
                    }
                });

                builder.setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Collections.sort(selectedItems, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer s1, Integer s2) {
                                return s1.compareTo(s2);
                            }
                        });
                        for(int i=0;i<selectedItems.size();++i){


                            int index = (int)selectedItems.get(i)-i;

                            secondCourseStarches.remove(index);
                        }
                        saveSecondCourseStarches();
                    }
                });
                builder.setNegativeButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }


    public void showSecondCourseSaladsDialog(final Context context, final TextView scTextView, final StringBuilder[] textResult){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Surówka:");

        builder.setItems(secondCourseSalads.toArray(new CharSequence[secondCourseSalads.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //scTextView.setText(secondCourseSalads.get(which));
                if(textResult[2]==null){
                    textResult[2] = new StringBuilder();
                }
                if(textResult[2]!=null){
                    textResult[2].setLength(0);
                }
                textResult[2].append(secondCourseSalads.get(which));
                StringBuilder secondCourseText = new StringBuilder();
                if(textResult[0]!=null&&textResult[0].toString().trim().length()>=1){
                    secondCourseText.append(textResult[0].toString());
                }
                if(textResult[1]!=null&&textResult[1].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[1].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[1].toString());
                }
                if(textResult[2].toString().trim().length()>=1){
                    secondCourseText.append(", ");
                    if(secondCourseText.length()+textResult[2].toString().length()>62){
                        secondCourseText.append("\n");
                    }
                    secondCourseText.append(textResult[2].toString());
                }
                scTextView.setText(secondCourseText.toString());
            }
        });

        builder.setPositiveButton("Dodaj nową", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Podaj nową surówkę:");
                final EditText input = new EditText(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        secondCourseSalads.add(input.getText().toString());
                        Collections.sort(secondCourseSalads, new Comparator<String>() {
                            @Override
                            public int compare(String s1, String s2) {
                                return s1.compareToIgnoreCase(s2);
                            }
                        });
                        //scTextView.setText(input.getText().toString());
                        if(textResult[2]==null){
                            textResult[2] = new StringBuilder();
                        }
                        if(textResult[2]!=null){
                            textResult[2].setLength(0);
                        }
                        textResult[2].append(input.getText().toString());
                        StringBuilder secondCourseText = new StringBuilder();
                        if(textResult[0]!=null&&textResult[0].toString().trim().length()>=1){
                            secondCourseText.append(textResult[0].toString());
                        }
                        if(textResult[1]!=null&&textResult[1].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[1].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[1].toString());
                        }
                        if(textResult[2].toString().trim().length()>=1){
                            secondCourseText.append(", ");
                            if(secondCourseText.length()+textResult[2].toString().length()>62){
                                secondCourseText.append("\n");
                            }
                            secondCourseText.append(textResult[2].toString());
                        }
                        saveSecondCourseSalads();
                        scTextView.setText(secondCourseText.toString());

                    }
                });

                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        builder.setNeutralButton("Edytuj listę", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Wybierz surówki do usunięcia:");

                final ArrayList selectedItems=new ArrayList();

                builder.setMultiChoiceItems(secondCourseSalads.toArray(new CharSequence[secondCourseSalads.size()]), null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedItems.add(which);

                        } else if (selectedItems.contains(which)) {
                            selectedItems.remove(Integer.valueOf(which));

                        }
                    }
                });

                builder.setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Collections.sort(selectedItems, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer s1, Integer s2) {
                                return s1.compareTo(s2);
                            }
                        });
                        for(int i=0;i<selectedItems.size();++i){
                            int index = (int)selectedItems.get(i)-i;
                            secondCourseSalads.remove(index);
                        }
                        saveSecondCourseSalads();
                    }
                });
                builder.setNegativeButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }


}
