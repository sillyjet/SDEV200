package com.example.mydigitalmischief;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Random;

public class Rat {
    public String DNA; // will be used to generate markings, color, and used in breeding
    public String name; // will be chosen by user
    public String gender; // true = female, false = male
    public int age; // counted in months
    public int weight; // counted in grams
    public boolean fixed; // true means the rat has been spayed or neutered
    public String color; // String name of rat's color
    public String eyeColor; //  DNA can be between 0 and 3 to indicate black, dark red, red, or pink
    public boolean dumbo; // DNA can only be set to 0, 1, or 2 to indicate non-dumbo, carrier, or dumbo (recessive trait)
    public boolean albino; // DNA can only be set to 0, 1, or 2 to indicate non-albino, carrier, or albino (recessive trait)
    public String rex; // DNA can only be set to 0, 1, or 2 to indicate non-rex, regular rex, or double rex (double rex appears hairless)
    public boolean hairless; // DNA can only be set to 0, 1, or 2 to indicate non-hairless, carrier, or hairless (recessive trait)
    public boolean belly;
    public boolean rightArm;
    public boolean leftArm;
    public boolean rightLeg;
    public boolean leftLeg;
    public boolean body;
    public String head; // DNA can only be set to 0, 1, 2, 3, 4 or 5 indicating no color, wedge, stripe, lightning, spot or solid
    public int interactive; // between 0 and 10, refers to how much interaction the rat prefers, 0 = shy and 10 = social
    public int kindness; // between 0 and 10, refers to how the rat treats humans and other rats
    public int energy; // between 0 and 10, refers to how energetic the rat is (decreases with age)
    public String colorHex; // hexadecimal value for the rat's color
    public StackPane image; // image that represents the rat

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
                this.eyeColor = "black";
        }
        this.dumbo = (rec(DNA.charAt(9)));
        this.albino = (rec(DNA.charAt(10)));
        if (DNA.charAt(11) == '2') {
            this.rex = "double";
        } else if (DNA.charAt(11) == '1') {
            this.rex = "single";
        } else {
            this.rex = "none";
        }
        this.hairless = (rec(DNA.charAt(12)));
        this.belly = (bin(DNA.charAt(13)));
        this.rightArm = (bin(DNA.charAt(14)));
        this.leftArm = (bin(DNA.charAt(15)));
        this.rightLeg = (bin(DNA.charAt(16)));
        this.leftLeg = (bin(DNA.charAt(17)));
        this.body = (bin(DNA.charAt(18)));
        switch (DNA.charAt(19)) {
            case '0':
                this.head = "no color";
                break;
            case '1':
                this.head = "wedge";
                break;
            case '2':
                this.head = "stripe";
                break;
            case '3':
                this.head = "lightning";
                break;
            case '4':
                this.head = "spot";
                break;
            case '5':
                this.head = "solid";
                break;
            default:
                this.head = "invalid";
        }
        this.interactive = (int) DNA.charAt(20);
        this.kindness = (int) DNA.charAt(21);
        this.energy = (int) DNA.charAt(22);
        if (albino) {
            this.belly = false;
            this.body = false;
            this.rightArm = false;
            this.leftArm = false;
            this.rightLeg = false;
            this.leftLeg = false;
            this.head = "no color";
            this.eyeColor = "pink";
        }
        this.image = this.generateImage(this.imageCode());
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

    public String unBin(boolean b) {
        if (b) {
            return "1";
        } else {
            return "0";
        }
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

    public void setRex(String rex) {
        this.rex = rex;
    }

    public void setHairless(boolean hairless) {
        this.hairless = hairless;
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

    public void setRight1(boolean body) {
        this.body = body;
    }

    public void setHead(String head) {
        this.head = head;
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

    public void setImage(StackPane image) {
        this.image = image;
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

    public String getRex() {
        return rex;
    }

    public boolean getHairless() {
        return hairless;
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

    public boolean getBody() {
        return body;
    }

    public String getHead() {
        return head;
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

    public StackPane getImage() {
        return image;
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

    public String imageCode() {
        StringBuilder str = new StringBuilder();
        String a;
        if (this.getAlbino()) {
            a = "A";
        } else if (this.getHairless() || this.getRex().equals("double")) {
            a = "H";
        } else {
            a = switch (this.getColor()) {
                case "black" -> "0";
                case "brown" -> "1";
                case "dark brown" -> "2";
                case "beige" -> "3";
                case "tan" -> "4";
                case "champagne" -> "5";
                case "cream" -> "6";
                case "gray" -> "7";
                case "light gray" -> "8";
                case "dark gray" -> "9";
                case "purple" -> "P";
                default -> "X";
            };
        }
        String b = switch (this.getEyeColor()) {
            case "black" -> "0";
            case "dark red" -> "1";
            case "red" -> "2";
            case "pink" -> "3";
            default -> "X";
        };
        String c = unBin(this.getDumbo());
        String d;
        if (!this.getHairless()) {
            if (this.getRex().equals("single")) {
                d = "1";
            } else {
                d = "0";
            }
        } else {
            d = "0";
        }
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        if (!a.equals("A") && !a.equals("H")) {
            e = unBin(this.getBelly());
            f = unBin(this.getRightArm());
            g = unBin(this.getLeftArm());
            h = unBin(this.getRightLeg());
            i = unBin(this.getLeftLeg());
            j = unBin(this.getBody());
            k = switch (this.getHead()) {
                case "no color" -> "0";
                case "wedge" -> "1";
                case "stripe" -> "2";
                case "lightning" -> "3";
                case "spot" -> "4";
                case "solid" -> "5";
                default -> "X";
            };
        } else if (a.equals("A")) {
            e = "0";
            f = "0";
            g = "0";
            h = "0";
            i = "0";
            j = "0";
            k = "0";
        } else {
            e = "1";
            f = "1";
            g = "1";
            h = "1";
            i = "1";
            j = "1";
            k = "5";
        }
        str.append(a + b + c + d + e + f + g + h + i + j + k);
        return str.toString();
    }

    public StackPane generateImage(String imageCode) {
        int i = 5;
        String filePath = "C:\\Users\\fishs\\IdeaProjects\\MyDigitalMischief\\";
        StackPane imagePane = new StackPane();
        String fileName = "base.png";
        Image baseImage = new Image(filePath + fileName);
        ImageView baseImageView = new ImageView(baseImage);
        Main.shrink(baseImageView, i);
        imagePane.getChildren().add(baseImageView);
        if (imageCode.charAt(0) != 'H') {
            fileName = switch (imageCode.charAt(0)) {
                case '0' -> "black.png";
                case '1' -> "brown.png";
                case '2' -> "darkbrown.png";
                case '3' -> "beige.png";
                case '4' -> "tan.png";
                case '5' -> "champagne.png";
                case '6' -> "cream.png";
                case '7' -> "gray.png";
                case '8' -> "lightgray.png";
                case '9' -> "darkgray.png";
                case 'P' -> "purple.png";
                case 'A' -> "albino.png";
                default -> "colorerror.png";
            };
            Image colorImage = new Image(filePath + fileName);
            ImageView colorImageView = new ImageView(colorImage);
            Main.shrink(colorImageView, i);
            imagePane.getChildren().add(colorImageView);
        }
        if (!bin(imageCode.charAt(9))) {
            Image bodyImage = new Image(filePath + "body.png");
            ImageView bodyImageView = new ImageView(bodyImage);
            Main.shrink(bodyImageView, i);
            imagePane.getChildren().add(bodyImageView);
        }
        if (!bin(imageCode.charAt(4))) {
            Image bellyImage = new Image(filePath + "belly.png");
            ImageView bellyImageView = new ImageView(bellyImage);
            Main.shrink(bellyImageView, i);
            imagePane.getChildren().add(bellyImageView);
        }
        if (!bin(imageCode.charAt(5))) {
            Image rightArmImage = new Image(filePath + "rightarm.png");
            ImageView rightArmImageView = new ImageView(rightArmImage);
            Main.shrink(rightArmImageView, i);
            imagePane.getChildren().add(rightArmImageView);
        }
        if (!bin(imageCode.charAt(6))) {
            Image leftArmImage = new Image(filePath + "leftarm.png");
            ImageView leftArmImageView = new ImageView(leftArmImage);
            Main.shrink(leftArmImageView, i);
            imagePane.getChildren().add(leftArmImageView);
        }
        if (!bin(imageCode.charAt(7))) {
            Image rightLegImage = new Image(filePath + "rightleg.png");
            ImageView rightLegImageView = new ImageView(rightLegImage);
            Main.shrink(rightLegImageView, i);
            imagePane.getChildren().add(rightLegImageView);
        }
        if (!bin(imageCode.charAt(8))) {
            Image leftLegImage = new Image(filePath + "leftleg.png");
            ImageView leftLegImageView = new ImageView(leftLegImage);
            Main.shrink(leftLegImageView, i);
            imagePane.getChildren().add(leftLegImageView);
        }
        if (imageCode.charAt(10) != '5') {
            fileName = switch (imageCode.charAt(10)) {
                case '0' -> "nocolor.png";
                case '1' -> "wedge.png";
                case '2' -> "stripe.png";
                case '3' -> "lightning.png";
                case '4' -> "spot.png";
                default -> "headerror.png";
            };
            Image headImage = new Image(filePath + fileName);
            ImageView headImageView = new ImageView(headImage);
            Main.shrink(headImageView, i);
            imagePane.getChildren().add(headImageView);
        }
        fileName = switch (imageCode.charAt(1)) {
            case '1' -> "darkredeye.png";
            case '2' -> "redeye.png";
            case '3' -> "pinkeye.png";
            default -> "blackeye.png";
        };
        Image eyeImage = new Image(filePath + fileName);
        ImageView eyeImageView = new ImageView(eyeImage);
        Main.shrink(eyeImageView, i);
        imagePane.getChildren().add(eyeImageView);
        if (bin(imageCode.charAt(2))) {
            fileName = "dumbo.png";
        } else {
            fileName = "standard.png";
        }
        Image earImage = new Image(filePath + fileName);
        ImageView earImageView = new ImageView(earImage);
        Main.shrink(earImageView, i);
        imagePane.getChildren().add(earImageView);
        if (bin(imageCode.charAt(3))) {
            Image furImage = new Image(filePath + "rex.png");
            ImageView furImageView = new ImageView(furImage);
            Main.shrink(furImageView, i);
            imagePane.getChildren().add(furImageView);
        }
        generateAndSetImage(imageCode);
        return imagePane;
    }

    public void generateAndSetImage(String imageCode) {
        int i = 12;
        String filePath = "C:\\Users\\fishs\\IdeaProjects\\MyDigitalMischief\\";
        StackPane imagePane = new StackPane();
        String fileName = "base.png";
        Image baseImage = new Image(filePath + fileName);
        ImageView baseImageView = new ImageView(baseImage);
        Main.shrink(baseImageView, i);
        imagePane.getChildren().add(baseImageView);
        if (imageCode.charAt(0) != 'H') {
            fileName = switch (imageCode.charAt(0)) {
                case '0' -> "black.png";
                case '1' -> "brown.png";
                case '2' -> "darkbrown.png";
                case '3' -> "beige.png";
                case '4' -> "tan.png";
                case '5' -> "champagne.png";
                case '6' -> "cream.png";
                case '7' -> "gray.png";
                case '8' -> "lightgray.png";
                case '9' -> "darkgray.png";
                case 'P' -> "purple.png";
                case 'A' -> "albino.png";
                default -> "colorerror.png";
            };
            Image colorImage = new Image(filePath + fileName);
            ImageView colorImageView = new ImageView(colorImage);
            Main.shrink(colorImageView, i);
            imagePane.getChildren().add(colorImageView);
        }
        if (!bin(imageCode.charAt(9))) {
            Image bodyImage = new Image(filePath + "body.png");
            ImageView bodyImageView = new ImageView(bodyImage);
            Main.shrink(bodyImageView, i);
            imagePane.getChildren().add(bodyImageView);
        }
        if (!bin(imageCode.charAt(4))) {
            Image bellyImage = new Image(filePath + "belly.png");
            ImageView bellyImageView = new ImageView(bellyImage);
            Main.shrink(bellyImageView, i);
            imagePane.getChildren().add(bellyImageView);
        }
        if (!bin(imageCode.charAt(5))) {
            Image rightArmImage = new Image(filePath + "rightarm.png");
            ImageView rightArmImageView = new ImageView(rightArmImage);
            Main.shrink(rightArmImageView, i);
            imagePane.getChildren().add(rightArmImageView);
        }
        if (!bin(imageCode.charAt(6))) {
            Image leftArmImage = new Image(filePath + "leftarm.png");
            ImageView leftArmImageView = new ImageView(leftArmImage);
            Main.shrink(leftArmImageView, i);
            imagePane.getChildren().add(leftArmImageView);
        }
        if (!bin(imageCode.charAt(7))) {
            Image rightLegImage = new Image(filePath + "rightleg.png");
            ImageView rightLegImageView = new ImageView(rightLegImage);
            Main.shrink(rightLegImageView, i);
            imagePane.getChildren().add(rightLegImageView);
        }
        if (!bin(imageCode.charAt(8))) {
            Image leftLegImage = new Image(filePath + "leftleg.png");
            ImageView leftLegImageView = new ImageView(leftLegImage);
            Main.shrink(leftLegImageView, i);
            imagePane.getChildren().add(leftLegImageView);
        }
        if (imageCode.charAt(10) != '5') {
            fileName = switch (imageCode.charAt(10)) {
                case '0' -> "nocolor.png";
                case '1' -> "wedge.png";
                case '2' -> "stripe.png";
                case '3' -> "lightning.png";
                case '4' -> "spot.png";
                default -> "headerror.png";
            };
            Image headImage = new Image(filePath + fileName);
            ImageView headImageView = new ImageView(headImage);
            Main.shrink(headImageView, i);
            imagePane.getChildren().add(headImageView);
        }
        fileName = switch (imageCode.charAt(1)) {
            case '1' -> "darkredeye.png";
            case '2' -> "redeye.png";
            case '3' -> "pinkeye.png";
            default -> "blackeye.png";
        };
        Image eyeImage = new Image(filePath + fileName);
        ImageView eyeImageView = new ImageView(eyeImage);
        Main.shrink(eyeImageView, i);
        imagePane.getChildren().add(eyeImageView);
        if (bin(imageCode.charAt(2))) {
            fileName = "dumbo.png";
        } else {
            fileName = "standard.png";
        }
        Image earImage = new Image(filePath + fileName);
        ImageView earImageView = new ImageView(earImage);
        Main.shrink(earImageView, i);
        imagePane.getChildren().add(earImageView);
        if (bin(imageCode.charAt(3))) {
            Image furImage = new Image(filePath + "rex.png");
            ImageView furImageView = new ImageView(furImage);
            Main.shrink(furImageView, i);
            imagePane.getChildren().add(furImageView);
        }
        this.setImage(imagePane);
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
        String c = String.valueOf(rand.nextInt(10));
        String d = String.valueOf(rand.nextInt(6));
        String e = String.valueOf(rand.nextInt(12));
        String f = String.valueOf(rand.nextInt(12));
        String g = String.valueOf(rand.nextInt(12));
        String h = String.valueOf(rand.nextInt(2));
        String i = String.valueOf(rand.nextInt(2));
        String j = String.valueOf(rand.nextInt(2));
        String k = String.valueOf(rand.nextInt(2));
        String l = String.valueOf(rand.nextInt(2));
        String m = "1";
        if (h.equals("0")) {
            m = String.valueOf(rand.nextInt(2));
        }
        String n = String.valueOf(rand.nextInt(6));
        String o = String.valueOf(rand.nextInt(10));
        String p = String.valueOf(rand.nextInt(10));
        String q = String.valueOf(rand.nextInt(10));
        str.append(a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q);
        return str.toString();
    }

    public String generateOffspringDNA(String DNA1, String DNA2) {

        return "this is an error please fix";
    }

    public String generateStandardColor() {
        String[] colorHexes = {"#111111", "#572800", "#210F00", "#B3845B", "#B39B5B", "#FFF39C", "#EDEAB2", "#777777", "#BBBBBB", "#333333"};
        Random rand = new Random();
        int i = rand.nextInt(colorHexes.length - 1);
        return colorHexes[i];
    }

    public String generateSpecialColor() {
        String[] colorHexes = {"#440075"};
        Random rand = new Random();
        if (colorHexes.length == 1) {
            return colorHexes[0];
        } else {
            int i = rand.nextInt(colorHexes.length - 1);
            return colorHexes[i];
        }
    }

    public String getColorName(String color) {
        String[] colorHexes = {"#111111", "#572800", "#210F00", "#B3845B", "#B39B5B", "#FFF39C", "#EDEAB2", "#777777", "#BBBBBB", "#333333", "#440075"};
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
