//package Compiler;
//
//import AbsSynTree.*;
//import AbsSynTree.Definitions.DistributionDef;
//import AbsSynTree.Definitions.FunctionDef;
//import AbsSynTree.Expressions.Id;
//import AbsSynTree.Expressions.Let;
//import AbsSynTree.Expressions.Operation;
//import AbsSynTree.Operators.Plus;
//
//public class Translator {
//
//    public String compile(Program program) {
//        System.out.println("Compiling " + program.getId().getName() + "...");
//
//        return compileExpr(program.getExpr());
//    }
//
//    private String compileExpr(Expression expr) {
//        String result = "";
//
//        if (expr instanceof Let) {
//            result = compileLet((Let) expr);
//        } else if (expr instanceof Operation) {
//            result = compileOperation((Operation) expr);
//        } else if (expr instanceof Constant) {
//            result = compileConstant((Constant) expr);
//        } else if (expr instanceof Id) {
//            result = compileId((Id) expr);
//        }
//
//        return result;
//    }
//
//    private String compileId(Id id) {
//        return id.getName();
//    }
//
//    private String compileOperation(Operation expr) {
//        String result = "";
//
//        Operator op = expr.getOp();
//
//        if (op instanceof Plus) {
//            result += compileAddition(expr.getLeft(), expr.getRight());
//        }
//
//        return result;
//    }
//
//    private String compileAddition(Expression left, Expression right) {
//        String result = "";
//
//        result += compileExpr(left) + compileExpr(right);
//        result += "iadd";
//
//        return result;
//    }
//
//    private String compileConstant(Constant cons) {
//        return "iconst_" + cons.getValue() + "\n";
//    }
//
//    private String compileLet(Let expr) {
//        return compileDef(expr.getDefn()) + compileExpr(expr.getExpr());
//    }
//
//    private String compileDef(Definition defn) {
//        String result = "";
//
//        if (defn instanceof FunctionDef) {
//            result = compileFunctionDef((FunctionDef) defn);
//        } else if (defn instanceof DistributionDef) {
//            result = compileDistributionDef((DistributionDef) defn);
//        }
//
//        return result;
//    }
//
//    private String compileFunctionDef(FunctionDef defn) {
//        String result = "";
//
//        for (Expression expr : defn.getExpr()) {
//            if (expr instanceof Constant) {
//                result = compileConstant((Constant) expr);
//            } else if (expr instanceof Operation) {
//                result = compileOperation((Operation) expr);
//            }
//        }
//
//        return result;
//    }
//
//    private String compileDistributionDef(DistributionDef defn) {
//        return "";
//    }
//
//
//}
