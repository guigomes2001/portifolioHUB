// ===== CÓDIGO PARA A SEÇÃO MULTIMÍDIA =====
document.addEventListener('DOMContentLoaded', function() {
    // Botões de visualização
    const viewButtons = document.querySelectorAll('.view-slide');
    
    // Mapeamento de slides para URLs (usando raw.githubusercontent.com)
    const slideFiles = {
        'habilidades': 'https://raw.githubusercontent.com/guigomes2001/portifolioHUB/main/assets/docs/apresentacao.pdf'
    };
    
    // Ao clicar, abrir direto no Google Docs Viewer em nova guia
    viewButtons.forEach(button => {
        button.addEventListener('click', function() {
            const slideType = this.getAttribute('data-slide');
            const fileUrl = slideFiles[slideType];
            
            if (fileUrl) {
                const viewerUrl = 'https://docs.google.com/viewer?url=' 
                                  + encodeURIComponent(fileUrl) 
                                  + '&embedded=true';
                window.open(viewerUrl, '_blank'); 
            }
        });
    });

    // Animações de entrada para os cards
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };
    
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animate');
            }
        });
    }, observerOptions);
    
    // Observar cards de slides
    document.querySelectorAll('.slide-card').forEach(card => {
        observer.observe(card);
    });
});
