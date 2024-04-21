package com.example.mydigitalmischief;

import java.util.Random;

public class Rat {
    public String DNA; // will be used to generate markings, color, and used in breeding
    public String name; // will be chosen by user
    public String gender; // can be female or male
    public int age; // counted in months
    public int weight; // counted in grams
    public boolean fixed; // true means the rat has been spayed or neutered
    public String color; // String name of hexadecimal value for the rat's color
    public String eyeColor; //  DNA can be between 0 and 3 to indicate black, dark red, red, or pink
    public boolean dumbo; // DNA can only be set to 0, 1, or 2 to indicate non-dumbo, carrier, or dumbo (recessive trait)
    public boolean albino; // DNA can only be set to 0, 1, or 2 to indicate non-albino, carrier, or albino (recessive trait)
    public boolean rex; // DNA can only be set to 0, 1, or 2 to indicate non-rex, regular rex, or double rex (double rex appears hairless)
    public boolean hairless; // DNA can only be set to 0, 1, or 2 to indicate non-hairless, carrier, or hairless (recessive trait)
    public boolean hooded;
    public boolean belly;
    public boolean rightArm;
    public boolean leftArm;
    public boolean rightLeg;
    public boolean leftLeg;
    public boolean right1;
    public boolean right2;
    public boolean right3;
    public boolean right4;
    public boolean right5;
    public boolean right6;
    public boolean back1;
    public boolean back2;
    public boolean back3;
    public boolean back4;
    public boolean back5;
    public boolean back6;
    public boolean left1;
    public boolean left2;
    public boolean left3;
    public boolean left4;
    public boolean left5;
    public boolean left6;
    public String blaze; // DNA can only be set to 0, 1, 2, 3, or 4 indicating no blaze, wedge, stripe, lightning, or spot
    public int interactive; // between 0 and 10, refers to how much interaction the rat prefers, 0 = shy and 10 = social
    public int kindness; // between 0 and 10, refers to how the rat treats humans and other rats
    public int energy; // between 0 and 10, refers to how energetic the rat is (decreases with age)
    public String colorHex; // hexadecimal value for the rat's color

    public Rat() {
        this.DNA = generateNewDNA();
        this.name = "unnamed";
        if (bin(DNA.charAt(0))) {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 7; i++) {
            str.append(DNA.charAt(i));
        }
        this.colorHex = str.toString();
        this.color = getColorName(colorHex);
        switch (DNA.charAt(8)) {
            case '0':
                this.eyeColor = "black";
                break;
            case '1':
                this.eyeColor = "dark red";
                break;
            case '2':
                this.eyeColor = "red";
                break;
            case '3':
                this.eyeColor = "pink";
                break;
            default:
                this.eyeColor = "invalid";
        }
        this.dumbo = (rec(DNA.charAt(9)));
        this.albino = (rec(DNA.charAt(10)));
        this.rex = (rec(DNA.charAt(11)));
        this.hairless = (rec(DNA.charAt(12)));
        this.hooded = (bin(DNA.charAt(13)));
        this.belly = (bin(DNA.charAt(14)));
        this.rightArm = (bin(DNA.charAt(15)));
        this.leftArm = (bin(DNA.charAt(16)));
        this.rightLeg = (bin(DNA.charAt(17)));
        this.leftLeg = (bin(DNA.charAt(18)));
        this.right1 = (bin(DNA.charAt(19)));
        this.right2 = (bin(DNA.charAt(20)));
        this.right3 = (bin(DNA.charAt(21)));
        this.right4 = (bin(DNA.charAt(22)));
        this.right5 = (bin(DNA.charAt(23)));
        this.right6 = (bin(DNA.charAt(24)));
        this.back1 = (bin(DNA.charAt(25)));
        this.back2 = (bin(DNA.charAt(26)));
        this.back3 = (bin(DNA.charAt(27)));
        this.back4 = (bin(DNA.charAt(28)));
        this.back5 = (bin(DNA.charAt(29)));
        this.back6 = (bin(DNA.charAt(30)));
        this.left1 = (bin(DNA.charAt(31)));
        this.left2 = (bin(DNA.charAt(32)));
        this.left3 = (bin(DNA.charAt(33)));
        this.left4 = (bin(DNA.charAt(34)));
        this.left5 = (bin(DNA.charAt(35)));
        this.left6 = (bin(DNA.charAt(36)));
        switch (DNA.charAt(37)) {
            case '0':
                this.blaze = "none";
                break;
            case '1':
                this.blaze = "wedge";
                break;
            case '2':
                this.blaze = "stripe";
                break;
            case '3':
                this.blaze = "lightning";
                break;
            case '4':
                this.blaze = "spot";
                break;
            default:
                this.blaze = "invalid";
        }
        this.interactive = DNA.charAt(38);
        this.kindness = DNA.charAt(39);
        this.energy = DNA.charAt(40);
    }

    public boolean makeBool(char c, char t) {
        return (c == t);
    }

    public boolean rec(char c) {
        return makeBool(c, '2');
    }

    public boolean bin(char c) {
        return makeBool(c, '1');
    }

    public void setDNA(String DNA) {
        this.DNA = DNA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setDumbo(boolean dumbo) {
        this.dumbo = dumbo;
    }

    public void setAlbino(boolean albino) {
        this.albino = albino;
    }

    public void setRex(boolean rex) {
        this.rex = rex;
    }

    public void setHairless(boolean hairless) {
        this.hairless = hairless;
    }

    public void setHooded(boolean hooded) {
        this.hooded = hooded;
    }

    public void setBelly(boolean belly) {
        this.belly = belly;
    }

    public void setRightArm(boolean rightArm) {
        this.rightArm = rightArm;
    }

    public void setLeftArm(boolean leftArm) {
        this.leftArm = leftArm;
    }

    public void setRightLeg(boolean rightLeg) {
        this.rightLeg = rightLeg;
    }

    public void setLeftLeg(boolean leftLeg) {
        this.leftLeg = leftLeg;
    }

    public void setRight1(boolean right1) {
        this.right1 = right1;
    }

    public void setRight2(boolean right2) {
        this.right2 = right2;
    }

    public void setRight3(boolean right3) {
        this.right3 = right3;
    }

    public void setRight4(boolean right4) {
        this.right4 = right4;
    }

    public void setRight5(boolean right5) {
        this.right5 = right5;
    }

    public void setRight6(boolean right6) {
        this.right6 = right6;
    }

    public void setBack1(boolean back1) {
        this.back1 = back1;
    }

    public void setBack2(boolean back2) {
        this.back2 = back2;
    }

    public void setBack3(boolean back3) {
        this.back3 = back3;
    }

    public void setBack4(boolean back4) {
        this.back4 = back4;
    }

    public void setBack5(boolean back5) {
        this.back5 = back5;
    }

    public void setBack6(boolean back6) {
        this.back6 = back6;
    }

    public void setLeft1(boolean left1) {
        this.left1 = left1;
    }

    public void setLeft2(boolean left2) {
        this.left2 = left2;
    }

    public void setLeft3(boolean left3) {
        this.left3 = left3;
    }

    public void setLeft4(boolean left4) {
        this.left4 = left4;
    }

    public void setLeft5(boolean left5) {
        this.left5 = left5;
    }

    public void setLeft6(boolean left6) {
        this.left6 = left6;
    }

    public void setBlaze(String blaze) {
        this.blaze = blaze;
    }

    public void setInteractive(int interactive) {
        this.interactive = interactive;
    }

    public void setKindness(int kindness) {
        this.kindness = kindness;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getDNA() {
        return DNA;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public boolean getFixed() {
        return fixed;
    }

    public String getColor() {
        return color;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean getDumbo() {
        return dumbo;
    }

    public boolean getAlbino() {
        return albino;
    }

    public boolean getRex() {
        return rex;
    }

    public boolean getHairless() {
        return hairless;
    }

    public boolean getHooded() {
        return hooded;
    }

    public boolean getBelly() {
        return belly;
    }

    public boolean getRightArm() {
        return rightArm;
    }

    public boolean getLeftArm() {
        return leftArm;
    }

    public boolean getRightLeg() {
        return rightLeg;
    }

    public boolean getLeftLeg() {
        return leftLeg;
    }

    public boolean getRight1() {
        return right1;
    }

    public boolean getRight2() {
        return right2;
    }

    public boolean getRight3() {
        return right3;
    }

    public boolean getRight4() {
        return right4;
    }

    public boolean getRight5() {
        return right5;
    }

    public boolean getRight6() {
        return right6;
    }

    public boolean getBack1() {
        return back1;
    }

    public boolean getBack2() {
        return back2;
    }

    public boolean getBack3() {
        return back3;
    }

    public boolean getBack4() {
        return back4;
    }

    public boolean getBack5() {
        return back5;
    }

    public boolean getBack6() {
        return back6;
    }

    public boolean getLeft1() {
        return left1;
    }

    public boolean getLeft2() {
        return left2;
    }

    public boolean getLeft3() {
        return left3;
    }

    public boolean getLeft4() {
        return left4;
    }

    public boolean getLeft5() {
        return left5;
    }

    public boolean getLeft6() {
        return left6;
    }

    public String getBlaze() {
        return blaze;
    }

    public int getInteractive() {
        return interactive;
    }

    public int getKindness() {
        return kindness;
    }

    public int getEnergy() {
        return energy;
    }

    public String getColorHex() {
        return colorHex;
    }

    public String[] makeBabies(String DNA) {
        int max = 10, min = 5;
        Random r = new Random();
        boolean normalSize = r.nextBoolean();
        if (!normalSize) {
            max = 20;
            min = 1;
        }
        int size = r.nextInt(max - min + 1) + min;
        String[] litter = new String[size];
        return litter;
    }

    public String generateNewDNA() {
        StringBuilder str = new StringBuilder();
        Random rand = new Random();
        String a = String.valueOf(rand.nextInt(2));
        String b;
        int special = rand.nextInt(100);
        if (special == 99) {
            b = generateSpecialColor();
        } else {
            b = generateStandardColor();
        }
        String c = String.valueOf(rand.nextInt(4));
        String d = String.valueOf(rand.nextInt(6));
        String e = String.valueOf(rand.nextInt(9));
        String f = String.valueOf(rand.nextInt(9));
        String g = String.valueOf(rand.nextInt(9));
        String h = String.valueOf(rand.nextInt(2));
        String i = String.valueOf(rand.nextInt(2));
        String j = String.valueOf(rand.nextInt(2));
        String k = String.valueOf(rand.nextInt(2));
        String l = String.valueOf(rand.nextInt(2));
        String m = String.valueOf(rand.nextInt(2));
        String n1 = String.valueOf(rand.nextInt(2));
        String n2 = String.valueOf(rand.nextInt(2));
        String n3 = String.valueOf(rand.nextInt(2));
        String n4 = String.valueOf(rand.nextInt(2));
        String n5 = String.valueOf(rand.nextInt(2));
        String n6 = String.valueOf(rand.nextInt(2));
        String o1 = String.valueOf(rand.nextInt(2));
        String o2 = String.valueOf(rand.nextInt(2));
        String o3 = String.valueOf(rand.nextInt(2));
        String o4 = String.valueOf(rand.nextInt(2));
        String o5 = String.valueOf(rand.nextInt(2));
        String o6 = String.valueOf(rand.nextInt(2));
        String p1 = String.valueOf(rand.nextInt(2));
        String p2 = String.valueOf(rand.nextInt(2));
        String p3 = String.valueOf(rand.nextInt(2));
        String p4 = String.valueOf(rand.nextInt(2));
        String p5 = String.valueOf(rand.nextInt(2));
        String p6 = String.valueOf(rand.nextInt(2));
        String q = String.valueOf(rand.nextInt(5));
        String r = String.valueOf(rand.nextInt(11));
        String s = String.valueOf(rand.nextInt(11));
        String t = String.valueOf(rand.nextInt(11));
        str.append(a + b + c + d + e + f + g + h + i + j + k + l + m + n1 + n2 + n3 + n4 + n5 + n6 + o1 + o2 + o3 + o4 + o5 + o6 + p1 + p2 + p3 + p4 + p5 + p6 + q + r + s + t);
        return str.toString();
    }

    public String generateOffspringDNA(String DNA1, String DNA2) {

        return "this is an error please fix";
    }

    public String generateStandardColor() {
        String[] colorHexes = {"#000000", "#572800", "#210F00", "#B3845B", "#B39B5B", "#FFF39C", "#EDEAB2", "#777777", "#BBBBBB", "#333333"};
        Random rand = new Random();
        int i = rand.nextInt(colorHexes.length - 1);
        return colorHexes[i];
    }

    public String generateSpecialColor() {
        String[] colorHexes = {"#440075"};
        Random rand = new Random();
        int i = rand.nextInt(colorHexes.length - 1);
        return colorHexes[i];
    }

    public String getColorName(String color) {
        String[] colorHexes = {"#000000", "#572800", "#210F00", "#B3845B", "#B39B5B", "#FFF39C", "#EDEAB2", "#777777", "#BBBBBB", "#333333", "#440075"};
        String[] colorNames = {"black", "brown", "dark brown", "beige", "tan", "champagne", "cream", "gray", "light gray", "dark gray", "purple"};
        String colorName = "error";
        for (int i = 0; i < colorHexes.length; i++) {
            if (color.equals(colorHexes[i])) {
                colorName = colorNames[i];
            }
        }
        return colorName;
    }
}
