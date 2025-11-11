package ui;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎓 " + "=".repeat(50));
        System.out.println("        EDUCONNECT - SISTEMA EDUCACIONAL");
        System.out.println("        Versão 1.0 - Sistema Consolidado");
        System.out.println("=".repeat(50) + " 🎓\n");

        System.out.println("📋 Funcionalidades disponíveis:");
        System.out.println("  • Cadastro completo de usuários, cursos e turmas");
        System.out.println("  • Controle de avaliações e notas");
        System.out.println("  • Relatórios e estatísticas");
        System.out.println("  • Autenticação por tipo de usuário");
        System.out.println("  • Testes de cenários de sucesso e falha");

        MenuUI menu = new MenuUI();
        menu.exibirMenuPrincipal();

        System.out.println("\n🙏 Obrigado por usar o EduConnect!");
        System.out.println("🎯 Sistema educacional consolidado e pronto para investidores!");
    }
}