def main():
    
    custo_posto = float(30000)
    custo_self_service = 105000.00
    lucro_cenario_a = float(-30000)
    lucro_cenario_b = float(-150000)
    atendidos_mes_cenario_a = float(35950.00)
    atendidos_mes_cenario_b = float(35944.00)
    mes = 0
    
    while (lucro_cenario_a > lucro_cenario_b):
        mes = mes +1
        lucro_cenario_a =lucro_cenario_a + (atendidos_mes_cenario_a*1.5) - (7500)
        lucro_cenario_b = lucro_cenario_b + (atendidos_mes_cenario_b * 1.5) - (3000)
        
    print("Ao fim de "+str(mes)+" meses, o lucro do cenario A é de: "+str(lucro_cenario_a)+" e o lucro do cenario b é de "+str(lucro_cenario_b))
    
main()